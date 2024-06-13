// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len==0) return nums[0];

        int[] dp = new int[len+1];
        dp[1] = nums[0];
        dp[2] = nums[1];

        for(int i=3; i<=len; i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[len];
    }
}