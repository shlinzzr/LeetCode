// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0; 
        int min = Integer.MAX_VALUE;
        for(int p : prices){
            
            res = Math.max(res, p-min);
            min = Math.min(min, p);
            
        }
        
        return res;
    }
}