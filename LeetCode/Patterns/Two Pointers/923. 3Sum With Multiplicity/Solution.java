class Solution {
    public int threeSumMulti(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        long count = 0;
        long MOD = 1_000_000_007;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            int reqSum = target - nums[i];

            while (j < k) {
                int currentSum = nums[j] + nums[k];
                if (currentSum == reqSum) {
                    if (nums[j] != nums[k]) {
                        long jCount = 1;
                        long kCount = 1;
                        while (j + 1 < k && nums[j] == nums[j+1]) {
                            jCount++;
                            j++;
                        }
                        while (k - 1 > j && nums[k] == nums[k-1]) {
                            kCount++;
                            k--;
                        }
                        
                        count += (jCount * kCount);
                        j++; 
                        k--; 
                    } 
                    else {
                        long length = k - j + 1;
                        count += (length * (length - 1)) / 2;
                        break;
                    }
                } else if (currentSum < reqSum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return (int)(count % MOD);
    }
}