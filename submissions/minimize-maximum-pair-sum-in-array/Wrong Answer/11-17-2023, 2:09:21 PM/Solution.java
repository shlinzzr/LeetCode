// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array

class Solution {
    public int minPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[0] + nums[len-1];
    }
}