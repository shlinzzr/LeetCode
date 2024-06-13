// https://leetcode.com/problems/minimum-number-of-coins-to-be-added

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        
        
        int len = coins.length;
        int[] dp = new int[target+1];
        
        List<Integer> list = new ArrayList<>();
        
        for(int c: coins){
            list.add(c);
        }
        
        int res = 0;
        
        for(int i=1; i<=target; i++){
           coinChange(list, i);
            
            
        }
        
        
        return list.size()-coins.length;
      
        
        
        
        
    }
    
    
     public int coinChange(List<Integer> coins, int amount) {
        int len = coins.size();
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=0; i<=amount; i++){
            for(int coin : coins){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
         
         if(dp[amount]==Integer.MAX_VALUE)
             coins.add(amount);

        return dp[amount]==Integer.MAX_VALUE? -1: dp[amount];
    }
}