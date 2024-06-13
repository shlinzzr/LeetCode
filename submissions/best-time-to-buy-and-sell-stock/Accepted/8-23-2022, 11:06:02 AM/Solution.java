// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, profit=0;
        
        for(int i=0; i<prices.length; i++){
            int p = prices[i];
            if(p<min)
                min=p;
            else 
                profit = Math.max(profit, p-min);
        }
        
        return profit;
    }
}