import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int num : nums.get(i)) {
                list.add(new int[]{num, i});
            }
        }

        mergeSort(list, 0, list.size() - 1);

        int[] freq = new int[n];
        int covered = 0;
        int left = 0;

        int[] ans = {
            list.get(0)[0],
            list.get(list.size() - 1)[0]
        };

        int diff = ans[1] - ans[0];

        for (int right = 0; right < list.size(); right++) {
            int listId = list.get(right)[1];

            if (++freq[listId] == 1) {
                covered++;
            }

            while (covered == n) {
                int start = list.get(left)[0];
                int end = list.get(right)[0];
                int currDiff = end - start;

                if (currDiff < diff || (currDiff == diff && start < ans[0])) {
                    ans[0] = start;
                    ans[1] = end;
                    diff = currDiff;
                }

                int leftListId = list.get(left)[1];
                if (--freq[leftListId] == 0) {
                    covered--;
                }

                left++;
            }
        }

        return ans;
    }

    private void mergeSort(List<int[]> list, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private void merge(List<int[]> list, int left, int mid, int right) {
        List<int[]> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i)[0] <= list.get(j)[0]) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(list.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }
}
