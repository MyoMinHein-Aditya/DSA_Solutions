class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] == nums[j]){
                    int res = i*j;
                    if(res % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
