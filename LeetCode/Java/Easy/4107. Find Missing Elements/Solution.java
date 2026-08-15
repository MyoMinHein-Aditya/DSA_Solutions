class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int num : nums){
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        List<Integer> miss_list = new ArrayList<>();
        for( int i = min; i <= max; i++){
            boolean found = false;
            for(int num : nums){
                if(num == i){
                    found = true;
                    break;
                }
            }
            if(!found){
                miss_list.add(i);
            }
        }
        return miss_list;
    }
}