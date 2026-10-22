class Solution {
    public int maxChunksToSorted(int[] arr) {
        int size = arr.length;
        int[] minarr = new int[size];
        int currmax = arr[0];

        minarr[size - 1] = arr[size - 1];

        int chunk = 1;

        for (int i = size - 2; i >= 0; i--) {
            minarr[i] = Math.min(minarr[i + 1], arr[i]);
        }

        for (int i = 0; i < size - 1; i++) {
            currmax = Math.max(currmax, arr[i]);

            if (currmax <= minarr[i + 1]) {
                chunk++;
            }
        }

        return chunk;
    }
}