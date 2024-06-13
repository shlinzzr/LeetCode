// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        int res =0;
        
        int len = prices.length;
        for(int i=1; i<len ;i++){
            if(prices[i] > prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        
        return res;
    }
}