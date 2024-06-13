// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {

        int max= 0;
        int len = prices.length;
        int[][] dp = new int[len+1][2];
        // for(int i=0;i<=len; i++){
        //     Arrays.fill(dp[i], Integer.MIN_VALUE/2);
        // }

        dp[1][1] = -prices[0];
        dp[1][0] = 0;

        for(int i=2; i<=len; i++){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
        }

        return dp[len][0];

        
    }
}