// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int max = 0;
        int len = prices.length;
        
        int hold=Integer.MIN_VALUE, sold=0;
        
        for(int p: prices){
            
            int h=hold, s=sold;
            
            hold = Math.max(hold, sold-p);
            sold = Math.max(sold, hold+p-fee);
            
            
        }        
        return sold;
    }
}