public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int days = 1, capi = 0;
            for (int w : weights) {
                if (capi + w > mid) {
                    days++;
                    capi = 0;
                }
                capi += w;
            }
            if (days > D) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
