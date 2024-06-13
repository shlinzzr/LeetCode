// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        //[1, 1, 44,  55, 1]
        
        // mincost[i] = cost[i] + Math.min(mincost[i-1], mincost[i-2])
        // mincost[0] = cost[0];
        // mincost[1] = cost[1];
        // mincost[2] = cost[2] + min(cost[0], cost[1]);
        
        
        
        int n = cost.length;
        
        int[] dp = new int[n];
        
        return Math.min( helper(cost, n-1, dp) , helper(cost, n-2, dp) );
    
            
    }
    
    private int helper(int[] cost, int i, int[] dp){
        if(i<0)
            return 0;
        
        if(i==0 || i==1)
            return cost[i];
        
        if(dp[i]!=0)
            return dp[i];
        
        dp[i] = cost[i] + Math.min(helper(cost, i-1, dp), helper(cost, i-2, dp));
        return dp[i];
        
        
    }
    
}