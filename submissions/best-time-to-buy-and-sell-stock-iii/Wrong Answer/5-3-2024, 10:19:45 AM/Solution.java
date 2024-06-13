// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len+1][5];

        dp[1][1] = -prices[0];
        dp[1][2] = -2*prices[0];
        
        for(int i=2; i<=len; i++){
            dp[i][4] = Math.max(dp[i-1][4], Math.max(dp[i-1][2]+prices[i-1]+prices[i-1], dp[i-1][3]+prices[i-1]));
            dp[i][3] = Math.max(dp[i-1][3], Math.max(dp[i-1][1]+prices[i-1], dp[i-1][2]+prices[i-1]));

            dp[i][2] = Math.max(dp[i-1][2], Math.max(dp[i-1][1]-prices[i-1], dp[i-1][0]-prices[i-1]-prices[i-1]));
            dp[i][1] = Math.max(dp[i-1][1], Math.max(dp[i-1][0]-prices[i-1], dp[i-1][2]+prices[i-1]));
            // dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][2]+prices[i-1]+prices[i-1], dp[i-1][1]+prices[i-1]));
        }

        return Math.max(dp[len][4], dp[len][3]);
    }
}