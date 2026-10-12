public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        int prev = Integer.MIN_VALUE;

        for (int num : nums1) {
            if (num != prev && binarySearch(nums2, num)) {
                temp[index++] = num;
                prev = num;
            }
        }

        return Arrays.copyOfRange(temp, 0, index);
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}