// https://leetcode.com/problems/coin-change-ii

class Solution {
    public int change(int amount, int[] coins) {
        
        // ref 322. Coin Change
        // ref 518. Coin Change II
        // ref 416. Partition Equal Subset Sum
        // ref 377. Combination Sum IV, 
        // 一維dp

        //先想二維

        
        int[][] dp = new int[amount+1][coins.length+1]; // use first j coin to sum up to i amount
        Arrays.fill(dp[0], 1); // 組成0的方式都是 1 種

        for(int j=1; j<= coins.length; j++){
            int c = coins[j-1];

            for(int i=1; i<=amount; i++){
                dp[i][j] = dp[i][j-1]; // 使用j種硬幣 base＝使用j-1種硬幣出發
          
                if(i-c>=0){
                    dp[i][j] += dp[i-c][j];
                }
            }
        }

        return dp[amount][coins.length];

        





       








        // 二維dp solution:
        // 
        // if(amount==0) return 1;
        // int len = coins.length;
        // int[][] dp = new int[len+1][amount+1]; //use the first i coin to add up to amount 
        // for(int i=1; i<=len; i++){
        //     dp[i][0]=1;

        //     for(int j=1; j<=amount; j++){
        //         dp[i][j] = dp[i-1][j];
        //         if(j-coins[i-1]>=0){
        //             dp[i][j] +=  dp[i][j-coins[i-1]];
        //         }
        //     }
        // }
        // return dp[len][amount];

        // i 0 1 2 3 4 5 6
        //dp 1 1 2 3 5
        
    }
}