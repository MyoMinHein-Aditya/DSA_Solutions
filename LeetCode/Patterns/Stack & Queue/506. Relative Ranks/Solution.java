class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            } else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            } else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            } else {
                result[pair[i][1]] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}
