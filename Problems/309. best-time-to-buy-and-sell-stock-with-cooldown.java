// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        int[] hold = new int[len+1];
        hold[0] = Integer.MIN_VALUE;
        int[] sold = new int[len+1];
        int[] cool = new int[len+1];
        
        int max = 0;
        
        for(int i=1; i<=len; i++){
            hold[i] = Math.max(hold[i-1], cool[i-1]-prices[i-1]);
            sold[i] = Math.max(sold[i-1], hold[i-1]+prices[i-1]);
            cool[i] = sold[i-1];
            
            max = Math.max(max, sold[i]);
        }
        
        return max;
        
        
        
    }
}