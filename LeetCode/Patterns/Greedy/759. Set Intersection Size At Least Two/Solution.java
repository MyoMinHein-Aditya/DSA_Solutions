class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        sort(intervals, 0, intervals.length - 1);

        int ans = 0;
        int a = -1;
        int b = -1;

        for (int[] in : intervals) {
            int l = in[0];
            int r = in[1];

            if (l > b) {
                ans += 2;
                a = r - 1;
                b = r;
            } else if (l > a) {
                ans += 1;
                a = b;
                b = r;
            }
        }
        return ans;
    }

    private void sort(int[][] intervals, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(intervals, left, mid);
            sort(intervals, mid + 1, right);
            merge(intervals, left, mid, right);
        }
    }

    private void merge(int[][] intervals, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[][] L = new int[n1][2];
        int[][] R = new int[n2][2];

        for (int i = 0; i < n1; i++) L[i] = intervals[left + i];
        for (int j = 0; j < n2; j++) R[j] = intervals[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            boolean condition = false;
            if (L[i][1] < R[j][1]) {
                condition = true;
            } else if (L[i][1] == R[j][1]) {
                if (L[i][0] > R[j][0]) {
                    condition = true;
                }
            }
            
            if (condition) {
                intervals[k] = L[i];
                i++;
            } else {
                intervals[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            intervals[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            intervals[k] = R[j];
            j++;
            k++;
        }
    }
}
