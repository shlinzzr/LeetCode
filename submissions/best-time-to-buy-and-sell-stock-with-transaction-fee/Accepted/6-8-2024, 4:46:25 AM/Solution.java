// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len+1][2];
        dp[1][1] =-prices[0];
        for(int i=2; i<=len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i-1]);
        }

        return dp[len][0];
        
    }
}