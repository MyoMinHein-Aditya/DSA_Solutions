class Solution {
    public int dominantIndex(int[] nums) {
        int largest_i = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[largest_i]) {
                largest_i = i;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i != largest_i && nums[i] * 2 > nums[largest_i]) {
                return -1;
            }
        }
        
        return largest_i;
    }
}
