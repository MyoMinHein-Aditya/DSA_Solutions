#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int findLHS(int* nums, int numsSize) {
    qsort(nums, numsSize, sizeof(int), cmp);

    int maxLength = 0;
    int start = 0;

    for (int i = 0; i < numsSize; i++) {
        // Keep shrinking window if difference is greater than 1
        while (nums[i] - nums[start] > 1) {
            start++;
        }

        // If difference is exactly 1, update max
        if (nums[i] - nums[start] == 1) {
            int length = i - start + 1;
            if (length > maxLength) {
                maxLength = length;
            }
        }
    }

    return maxLength;
}

