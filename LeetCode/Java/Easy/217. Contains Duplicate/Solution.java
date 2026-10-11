class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }
        int[] freq = new int[max - min + 1];
        for (int num : nums) {
            int index = num - min;
            if (freq[index] > 0) {
                return true;
            }
            freq[index]++;
        }
        return false;
    }

}