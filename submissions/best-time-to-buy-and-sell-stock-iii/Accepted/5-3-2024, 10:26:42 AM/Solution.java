// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int buyA = -prices[0];
        int sellA = 0;
        int buyB = -prices[0];
        int sellB = 0;
        for (int i = 1; i < n; i++) {
            buyA = Math.max(buyA, -prices[i]);
            sellA = Math.max(sellA, buyA + prices[i]);
            buyB = Math.max(buyB, sellA - prices[i]);
            sellB = Math.max(sellB, buyB + prices[i]);
        }
        
        return Math.max(sellA, sellB);
    }
}