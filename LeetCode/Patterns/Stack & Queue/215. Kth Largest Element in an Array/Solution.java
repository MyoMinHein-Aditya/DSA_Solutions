class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                int temp = nums[storeIndex];
                nums[storeIndex] = nums[i];
                nums[i] = temp;
                storeIndex++;
            }
        }

        int temp = nums[storeIndex];
        nums[storeIndex] = nums[right];
        nums[right] = temp;

        return storeIndex;
    }
}
