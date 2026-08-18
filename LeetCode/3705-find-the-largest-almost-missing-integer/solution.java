class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] count = new int[51];
        int n = nums.length;
        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];
            for (int j = i; j < i + k; j++) {
                int num = nums[j];
                if (!seen[num]) {
                    count[num]++;
                    seen[num] = true;
                }
            }
        }
        int largest = -1;
        for (int i = 0; i <= 50; i++) {
            if (count[i] == 1) {
                largest = i;
            }
        }
        return largest;
    }
}

