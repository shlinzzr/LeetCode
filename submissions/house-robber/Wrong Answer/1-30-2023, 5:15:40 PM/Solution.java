// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int len  = nums.length;
        int[] dp = new int[len+1];
        
        for(int i=1; i<len; i++){
            dp[i+1]=Math.max(dp[i], dp[i-1]+nums[i-1]);
        }
        
        return dp[len];
        
        
        
    }
}