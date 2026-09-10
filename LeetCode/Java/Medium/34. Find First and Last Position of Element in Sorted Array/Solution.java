class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, 0, nums.length - 1, true);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = findBound(nums, target, 0, nums.length - 1, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, int left, int right, boolean isFirst) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (isFirst) {
                int leftBound = findBound(nums, target, left, mid - 1, true);
                return (leftBound != -1) ? leftBound : mid;
            } else {
                int rightBound = findBound(nums, target, mid + 1, right, false);
                return (rightBound != -1) ? rightBound : mid;
            }
        } else if (nums[mid] < target) {
            return findBound(nums, target, mid + 1, right, isFirst);
        } else {
            return findBound(nums, target, left, mid - 1, isFirst);
        }
    }
}
