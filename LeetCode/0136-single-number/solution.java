class Solution {
    public int singleNumber(int[] nums) {
        int unique = 0;
        int i = 0;
        while(i < nums.length){
            unique ^= nums[i]; 
            i++;
        }
        return unique;
    }
}
