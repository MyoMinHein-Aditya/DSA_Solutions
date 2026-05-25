class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        int res=-1;
        for(int i=0;i<n;i++){
           int curr=nums[i];
            int sum=0;
            while(curr!=0){
                int rem=curr%10;
                sum+=rem;
                curr/=10;
            }
            if(sum==i) {
                res=i;
                return i;
            }
        }
        return res;
    }
}
