// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        
        int[] dp = new int[len+2];
        dp[0]=0;
        dp[1] = cost[0];
        
        for(int i=2; i<=len+1; i++){
            dp[i] = (i==len+1? 0 : cost[i-1]) + Math.min(dp[i-1], dp[i-2]);
            
        }
        
        return dp[len+1];
    }
}