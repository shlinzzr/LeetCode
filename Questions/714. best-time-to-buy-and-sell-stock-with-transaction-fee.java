// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        // dp0 = 0
        // dp1 = 0;
        // dp2 = 


        int hold = Integer.MIN_VALUE/2;
        int sold = 0;

        for(int p : prices){
            int h = hold;
            int s = sold;

            hold = Math.max(hold, sold-p);
            sold = Math.max(sold, hold+p-fee);
        }


        return sold;

    }
}
