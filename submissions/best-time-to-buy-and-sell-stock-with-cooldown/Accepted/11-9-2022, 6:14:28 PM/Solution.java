// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] prices) {
        int hold=Integer.MIN_VALUE, sold=0, rest=0;
        
        for(int p : prices){
            int h=hold, s=sold, r=rest;
            hold = Math.max(h, r-p);
            sold = h+p;
            rest = Math.max(r, s);
        }
        
        return Math.max(sold, rest);
    }
}