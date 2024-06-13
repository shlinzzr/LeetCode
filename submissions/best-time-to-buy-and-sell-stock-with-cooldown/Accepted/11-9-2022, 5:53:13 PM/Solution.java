// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] prices) {
        int buy= Integer.MIN_VALUE, sell=0, cool=0;
        
        for(int p : prices){
            
            int b=buy, s=sell, c=cool;
            buy = Math.max(b, c-p);
            sell = b+p;
            cool = Math.max(c, s);
            
        }
        return Math.max(sell, cool);   
    }
}