class Solution {
    public int maxElement(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    public boolean isValid(int[] piles, int mid, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + mid - 1) / mid;
            if (totalHours > h) {
                return false;
            }
        }
        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxElement(piles);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

