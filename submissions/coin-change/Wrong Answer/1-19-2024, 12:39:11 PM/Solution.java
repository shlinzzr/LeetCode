// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int len = coins.length;
        int[] dp = new int[amount+1]; //湊成amount 的組合數
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++){
            
            for(int c : coins){
                if(i-c>=0 && dp[i-c]!=Integer.MAX_VALUE){
                    
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                    
                }
            }
        }
        
        return dp[amount];
        
        
        
        
        
    }
}