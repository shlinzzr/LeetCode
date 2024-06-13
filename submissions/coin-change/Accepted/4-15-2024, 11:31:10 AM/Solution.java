// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<=amount; i++){

            for(int c: coins){

                if(i-c>=0 && dp[i-c]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-c]+1);   
                }
            }

        }

        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];


        // [1, 2 , 5] 

        // amount 0 1 2 3 4 5 6 7 8 9 10 11
        //   dp.  0 x x x x x x x x x  x  x

        //  i=1   0 1
        //  i=2   0 1 1
        //  i=3.  0 1 1 2
        //  i=4.  0 1 1 2 2
        //. i=5.  0 1 1 2 2 1
        //  i=6.  0 1 1 2 2 1 2
        //  i=7.  0 1 1 2 2 1 2 2
        //  i=8.  0 1 1 2 2 1 2 2 3
        //  i=9   0 1 1 2 2 1 2 2 3 3
        //  i=10  0 1 1 2 2 1 2 2 3 3 2
        // 
        
    }
}