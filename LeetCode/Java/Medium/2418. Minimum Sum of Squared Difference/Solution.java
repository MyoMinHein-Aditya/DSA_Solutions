class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diffs = new long[n];
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs((long) nums1[i] - nums2[i]);
            totalDiff += diffs[i];
        }

        long k = (long) k1 + k2;

        if (totalDiff <= k) return 0;
        
        Arrays.sort(diffs);
        
        long left = 0, right = diffs[n - 1], maxDiff = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            for (long diff : diffs) {
                if (diff > mid) count += (diff - mid);
            }
            if (count <= k) {
                maxDiff = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        long remainingK = k;
        for (int i = 0; i < n; i++) {
            if (diffs[i] > maxDiff) {
                remainingK -= (diffs[i] - maxDiff);
                diffs[i] = maxDiff;
            }
        }
        for (int i = n - 1; i >= 0 && remainingK > 0; i--) {
            if (diffs[i] > 0) {
                diffs[i]--;
                remainingK--;
            }
        }
        long result = 0;
        for (long diff : diffs) {
            result += diff * diff;
        }
        return result;
    }
}
