// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=0;
        
        
        int a=1;
        while(a<=amount){
            int min = Integer.MAX_VALUE;
            
            for(int coin : coins){
                if(a-coin>=0 && dp[a-coin]!=-1){
                    min = dp[a-coin]<min ? dp[a-coin] : min;
                }
            }
            dp[a] = min==Integer.MAX_VALUE? -1 : min+1;
            a++;
        }
        
        
        return dp[amount];
    }
}