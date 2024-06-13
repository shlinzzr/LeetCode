// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        // dp[2] = Math.max (dp[0] + nums[1] , dp[1]);
        
        for(int i=2; i<=len; i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[len];
        
    }
}