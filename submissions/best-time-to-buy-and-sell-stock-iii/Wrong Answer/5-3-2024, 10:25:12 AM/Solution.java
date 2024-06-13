// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii

class Solution {
    public int maxProfit(int[] prices) {

        int buy1=0, buy2=0, sell1=0, sell2=0;
        buy1 = -prices[0];
        buy2 = -prices[0];

        for(int i=2;i<prices.length; i++){

            sell2 = Math.max(sell2, buy2+prices[i-1]+prices[i-1]);
            sell1 = Math.max(sell1, Math.max(buy2+prices[i-1], buy1+prices[i-1]+prices[i-1]));
            buy2 = Math.max(buy2, Math.max(-prices[i-1]-prices[i-1], buy1-prices[i-1]));
            buy1 = Math.max(buy1, -prices[i-1]);
        }

        return sell2;

        
    }
}