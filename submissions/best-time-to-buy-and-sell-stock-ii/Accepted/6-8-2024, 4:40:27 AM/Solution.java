// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {

        int max= 0 ;

        int len = prices.length;
        // 2-d
        // int[][] dp = new int[len+1][2];
        // dp[1][1] = -prices[0];

        // for(int i=2; i<=len; i++){
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
        //     dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        // }


        // return dp[len][0];

        int[] dp = new int[len+1];
        dp[1] = -prices[0];

         for(int i=2; i<=len; i++){
            int[] tmp = Arrays.copyOf(dp, 2);
            dp[0] = Math.max(tmp[0], tmp[1]+prices[i-1]);
            dp[1] = Math.max(tmp[1], tmp[0]-prices[i-1]);
         }

         return dp[0];
        
    }
}