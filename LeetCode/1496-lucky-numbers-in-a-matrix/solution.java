import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        // for (int i=0; i<m; i++) {
        //  for (int j=0; j<n; j++) {
        //   }
        // }
        
        int[] rowMin = new int[m];

        for (int i = 0; i < m; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                }
            }
            rowMin[i] = minVal;
        }
        int[] colMax = new int[n];
        
        for (int j = 0; j < n; j++) {
            int maxVal = Integer.MIN_VALUE; 
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                }
            }
            colMax[j] = maxVal;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }
}

