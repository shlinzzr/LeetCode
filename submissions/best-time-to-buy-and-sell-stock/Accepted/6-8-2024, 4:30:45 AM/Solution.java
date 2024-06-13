// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max= 0 ;
        for(int p : prices){
            max = Math.max(max, p-min);
            min = Math.min(min, p);
        }

        return max;
        
    }
}