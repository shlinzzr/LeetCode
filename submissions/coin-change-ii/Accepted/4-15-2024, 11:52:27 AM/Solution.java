// https://leetcode.com/problems/coin-change-ii

class Solution {
    public int change(int amount, int[] coins) {
        
        
        Arrays.sort(coins);
        int len = coins.length;
        
        int[][] dp = new int[len+1][amount+1]; // 使用i種coins的時候 組成amount的方法數
        
        for(int i=1; i<=len; i++){
            
            dp[i][0]=1; //組成0元的方法數都是1種
            
            for(int j=1; j<=amount; j++){
                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1]>=0)
                    dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        
        return dp[len][amount];
         
        
    }
}