// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] prices) {
        
        int hold=Integer.MIN_VALUE;
        int sold=0;
        int cool=0;

        for(int p : prices){

            // 買入(hold) -> 賣出(sold) -> (cd)cool
            
            int h=hold, s=sold, c=cool;
            hold = Math.max(h, c-p); // 目前收益 = 上次cd - 買入這隻股票
            sold = Math.max(s, h+p);// 目前收益 = 之前持有＋變賣這隻股票
            cool = Math.max(c, s); //目前收益 = 上次賣出後的狀態



        }

        return sold;




    }
}