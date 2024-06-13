// https://leetcode.com/problems/coin-change-ii

class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                
//                 if(j-coins[i-1]>=0)
                
//                 dp[i][j] = dp[i-1][j] +  dp[i][j-coins[i-1]];
                
                 dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        
        // for(int d: dp){
        //     System.out.println(d);
        // }
        
        return dp[coins.length][amount];
        
        // 2 : 1+1, 2
        // 
        // 3 : 1+1+1  2+1 
     
        
        
        // return dp[amount];
        
        
        
    }
}