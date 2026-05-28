class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
            else if(nums[i] == 1) ones++;
            else if(nums[i] == 2) twos++;
        }
        
        for(int j = 0; j < zeros; j++) {
            nums[j] = 0;
        }
        
        for(int j = zeros; j < zeros + ones; j++) {
            nums[j] = 1;
        }
        
        for(int j = zeros + ones; j < nums.length; j++) {
            nums[j] = 2;
        }
    }
}
