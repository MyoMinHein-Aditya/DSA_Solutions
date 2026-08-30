class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int first = Math.min(minIdx, maxIdx);
        int second = Math.max(minIdx, maxIdx);
        
        int delFront = second + 1;
        int delBack = n - first;
        int delBoth = (first + 1) + (n - second);
        
        return Math.min(delFront, Math.min(delBack, delBoth));
    }
}
