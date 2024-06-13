// https://leetcode.com/problems/coin-change-ii

class Solution {
    public int change(int amount, int[] coins) {
    
        //此問題是在問 “總共” 有幾種方法 所以是舊方法的相加
        
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;  // 組成amount=0的方法都是1
            
            for (int j = 1; j <= amount; j++) {
                
//                 if(j-coins[i-1]>=0)
                
//                     dp[i][j] = dp[i-1][j] +  dp[i][j-coins[i-1]];
                
                 dp[i][j] = dp[i-1][j]/*之前其他硬幣的組成方法*/ 
                          + (j >= coins[i-1] ? /*如果amount>=coin*/ dp[i][j-coins[i-1]] /*減去之*/: 0);
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