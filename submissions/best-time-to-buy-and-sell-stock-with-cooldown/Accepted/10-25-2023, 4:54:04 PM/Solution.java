// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int hold = -prices[0];
        int sold = 0;
        int cool = 0;

        int max= 0 ;

        for(int i=0; i<len; i++){

            hold = Math.max(hold, cool-prices[i]);
            cool = Math.max(cool, sold);
            sold = Math.max(sold, hold+prices[i]);
           
            
            max=  Math.max(max, sold);
        }

        return max;


    }
}