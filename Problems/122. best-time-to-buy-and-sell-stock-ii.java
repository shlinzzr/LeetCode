// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        // int res = 0;
        // for(int i=1; i<len; i++){

        //     if(prices[i]>prices[i-1])
        //         res += prices[i]-prices[i-1];
        // }

        // return res;


        int[] hold = new int[len+1];
        int[] sold = new int[len+1];
        hold[0] = -prices[0];

        int max= 0;
        for(int i=1; i<len; i++){

            hold[i] = Math.max(hold[i-1], sold[i-1]-prices[i]);
            sold[i] = Math.max(sold[i-1], hold[i-1]+prices[i]);
            max = Math.max(max, sold[i]);
        }

        return max;



    }
}