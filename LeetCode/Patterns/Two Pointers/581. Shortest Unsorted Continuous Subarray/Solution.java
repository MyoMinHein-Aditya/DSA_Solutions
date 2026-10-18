class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, l = 0, r = -1, hi = Integer.MIN_VALUE, lo = Integer.MAX_VALUE;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < (hi = Math.max(hi, nums[i]))) r = i;
            if (nums[j] > (lo = Math.min(lo, nums[j]))) l = j;  
        }
        return r - l + 1;
    }
}