// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements

class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        return k*nums[len-1] + (k*(k-1)/2);
    }
}