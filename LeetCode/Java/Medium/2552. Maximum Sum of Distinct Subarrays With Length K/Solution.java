class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;

        for (int i = 0; i < nums.length - k; i++) {
            long a = nums[i];
            long b = nums[i + 1];
            long c = nums[i + 2];
            if (a != b && b != c && c != a) {
                long sum = a + b + c;
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}