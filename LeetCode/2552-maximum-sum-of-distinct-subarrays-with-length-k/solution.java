class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int[] counts = new int[100001];
        int duplicateCount = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            if (counts[nums[i]] > 0) {
                duplicateCount++;
            }
            counts[nums[i]]++;
        }

        if (duplicateCount == 0) {
            maxSum = sum;
        }

        int low = 0;
        for (int high = k; high < nums.length; high++) {
            sum += nums[high];
            if (counts[nums[high]] > 0) {
                duplicateCount++;
            }
            counts[nums[high]]++;

            int leftElement = nums[low];
            sum -= leftElement;
            counts[leftElement]--;
            if (counts[leftElement] > 0) {
                duplicateCount--;
            }
            low++;

            if (duplicateCount == 0) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}

