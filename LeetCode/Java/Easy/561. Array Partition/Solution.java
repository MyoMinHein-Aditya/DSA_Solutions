class Solution {
    public int arrayPairSum(int[] nums) {
        int sum=0;
        int[] frequencyAtIndex=new int[20001];    

        for(int i=0;i<nums.length;i++){
            frequencyAtIndex[nums[i]+10000]++;
        }
        boolean take=true;
        for(int j=0;j<frequencyAtIndex.length;j++){
            while(frequencyAtIndex[j]>0){
                if(take==true){
                    sum+=(j-10000);
                }
                take=!take;
                frequencyAtIndex[j]--;

            }
        }
        return sum;
    }
}