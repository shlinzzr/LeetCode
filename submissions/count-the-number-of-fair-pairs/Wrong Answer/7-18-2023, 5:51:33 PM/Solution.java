// https://leetcode.com/problems/count-the-number-of-fair-pairs

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            
            long b = higher(nums, i, upper-nums[i]);
            long a = floor(nums, i, lower-nums[i]);
            result += (b-1)-a+1;
        }
        return result;
    }
    public long higher(int[] nums, int index, int target) {
        int start = index + 1;
        int end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > (target)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
     public long floor(int[] nums, int index, int target) {
        int start = index + 1;
        int end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < (target)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}