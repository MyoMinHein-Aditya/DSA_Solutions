class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        if (max == min) return 0;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            if (num < bucketMin[idx]) bucketMin[idx] = num;
            if (num > bucketMax[idx]) bucketMax[idx] = num;
        }
        int maxGap = 0;
        int prevMax = bucketMax[0];
        for (int i = 1; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue;
            int gap = bucketMin[i] - prevMax;
            if (gap > maxGap) maxGap = gap;
            prevMax = bucketMax[i];
        }
        return maxGap;
    }
}
