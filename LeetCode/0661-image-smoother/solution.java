class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            int t = Math.max(0, i - 1);
            int b = Math.min(n - 1, i + 1);

            for (int j = 0; j < m; j++) {
                int l = Math.max(0, j - 1);
                int r = Math.min(m - 1, j + 1);

                int sum = 0;
                int count = 0;

                for (int row = t; row <= b; row++) {
                    for (int col = l; col <= r; col++) {
                        sum += img[row][col];
                        count++;
                    }
                }

                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}

