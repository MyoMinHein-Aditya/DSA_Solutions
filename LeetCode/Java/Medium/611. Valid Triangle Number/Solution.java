class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) continue;
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                int target = nums[i] + nums[j];
                
                int low = k, high = n - 1;
                int bestK = j;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (nums[mid] < target) {
                        bestK = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                count += (bestK - j);
            }
        }
        return count;
    }
}