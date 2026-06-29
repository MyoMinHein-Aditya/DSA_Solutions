class Solution {
    public static void sort(int []arr){
        for(int i = 0 ; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while( j >= 0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static List<Integer> search(int [] arr, int tar){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == tar){
                list.add(i);
            }
        }
        return list;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        sort(nums);
        return search(nums, target);
    }
}
