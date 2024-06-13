// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] prices) {
        
        int hold=Integer.MIN_VALUE;
        int sold=0;
        int cool=0;

        for(int p : prices){

            int h=hold, s=sold, c=cool;
            hold = Math.max(h, c-p);
            sold = Math.max(s, h+p);
            cool = Math.max(c, s);



        }

        return sold;




    }
}