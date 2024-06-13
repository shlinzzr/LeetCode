// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        //[1, 1, 44,  55, 1]
        
        // mincost[i] = cost[i] + Math.min(mincost[i-1], mincost[i-2])
        // mincost[0] = cost[0];
        // mincost[1] = cost[1];
        // mincost[2] = cost[2] + min(cost[0], cost[1]);
        
        int n = cost.length;
        return Math.min( helper(cost, n-1) , helper(cost, n-2) );
    
            
    }
    
    private int helper(int[] cost, int i){
        if(i<0)
            return 0;
        else if(i==0 || i==1)
            return cost[i];
        
        
        else 
            return cost[i] + Math.min(helper(cost, i-1), helper(cost, i-2));
        
        
    }
    
}