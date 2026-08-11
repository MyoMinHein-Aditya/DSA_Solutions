public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = 1, currentLoad = 0;
            for (int w : weights) {
                if (currentLoad + w > mid) {
                    days++;
                    currentLoad = 0;
                }
                currentLoad += w;
            }
            if (days > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
