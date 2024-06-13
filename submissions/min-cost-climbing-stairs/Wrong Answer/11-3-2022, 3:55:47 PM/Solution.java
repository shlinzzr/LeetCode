// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    
    int[] dp;
    
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        dp = new int[len+1];
        return Math.min( helper(cost, len-2), helper(cost, len-1));
    }
    
    private int helper(int[] cost, int n){
        if(n<2){
            return cost[n];
        }
        
        if(dp[n]>0)
            return dp[n];
        
        
        dp[n] = Math.min( helper(cost, n-2), helper(cost, n-1)) + cost[n-1];
        
        return dp[n];
    }
    
}