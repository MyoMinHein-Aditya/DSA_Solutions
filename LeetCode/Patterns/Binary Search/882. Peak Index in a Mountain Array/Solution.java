class Solution {
    
    public int peakIndex(int arr[], int right, int left){
        if(left >= right) return left;
        int mid = left + (right-left)/2;
        if(arr[mid] < arr[mid+1]){
            return peakIndex(arr,mid+1,right);
        }
        else{
            return peakIndex(arr,left,mid);
        }
    }
    
    public int peakIndexInMountainArray(int[] arr) {
        int right = arr.length-1, left = 0;
        return peakIndex(arr,right,left);
    }
}