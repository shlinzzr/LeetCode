// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //https://www.youtube.com/watch?v=H9bfqozjoqs
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<amount+1;i++){
            
            for(int c : coins){
                if(i-c>=0){
                    dp[i] = Math.min(dp[i], 1+dp[i-c]);    
                }
            }
        }
         return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }
    

}