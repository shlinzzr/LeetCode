// https://leetcode.com/problems/count-pairs-in-two-arrays

class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        long result = 0;
        int n = nums1.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int start = binarySearch(nums, i);
            result += (n - start);
        }

        return result;
    }

    private int binarySearch(int[] nums, int index) {
        int left = index + 1;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] + nums[index] <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}