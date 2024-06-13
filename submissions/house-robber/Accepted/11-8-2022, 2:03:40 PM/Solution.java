// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        int[] dp = new int[len+1]; // dp[len] 表示 maximum amount of money you can rob
        
        dp[0] = 0;       //==> i=0 : dp[1] = max(dp[0], nums[0]])
        dp[1] = nums[0]; //==> i=1 : dp[2] = max(dp[1], dp[0]+nums[1])
        for(int i=1; i<len; i++){
            dp[i+1] = Math.max(nums[i] + dp[i-1], dp[i] );
            
        }
        return dp[len];
        
    }
}