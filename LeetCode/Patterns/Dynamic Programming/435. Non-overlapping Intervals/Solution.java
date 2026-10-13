// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//         if (intervals.length == 0) return 0;

//         for (int i = 0; i < intervals.length - 1; i++) {
//             for (int j = 0; j < intervals.length - 1 - i; j++) {
//                 if (intervals[j][1] > intervals[j + 1][1]) {
//                     int[] temp = intervals[j];
//                     intervals[j] = intervals[j + 1];
//                     intervals[j + 1] = temp;
//                 }
//             }
//         }

//         int end = intervals[0][1];
//         int count = 0;

//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i][0] < end) {
//                 count++;
//             } else {
//                 end = intervals[i][1];
//             }
//         }

//         return count;
//     }
// }

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals.length - 1 - i; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        int n = intervals.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int maxNonOverlap = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxNonOverlap) {
                maxNonOverlap = dp[i];
            }
        }

        return n - maxNonOverlap;
    }
}
