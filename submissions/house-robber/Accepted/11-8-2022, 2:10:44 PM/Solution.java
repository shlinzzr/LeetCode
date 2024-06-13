// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        
        int[] dp = new int[len+1];
        dp[0]=0;
        dp[1]=nums[0];
        
        // dp[i+1] = max(nums[i]+dp[i-1], dp[i])
        
        for(int i=1; i<len; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }
        
        return dp[len];
        
        
        
    }
}