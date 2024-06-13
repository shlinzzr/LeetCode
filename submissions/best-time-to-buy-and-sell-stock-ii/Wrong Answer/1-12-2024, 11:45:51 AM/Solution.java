// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        // int min = Integer.MAX_VALUE;
        // int max= 0;
        // for(int i =0; i<len; i++){
        //     max= Math.max(max, prices[i]-min);
        //     min = Math.min(min, prices[i]);
        // }
        
        int[][] dp = new int[len][2]; // the max profit on day i with/without stock
        dp[0][1] = -prices[0];
        
        int max= 0 ;
        for(int i=1; i<len; i++){
            int p = prices[i-1];
            
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-p);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+p);
            
            
            max = Math.max(max, dp[i][0]);
        }
        
        
        return max;
    }
}