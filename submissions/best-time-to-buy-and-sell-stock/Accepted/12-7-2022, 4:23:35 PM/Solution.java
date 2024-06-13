// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        for(int p : prices){
            min = Math.min(min, p);


            max = max==Integer.MIN_VALUE?  0 : Math.max(max, p-min);



        }

        return max;

    }
}