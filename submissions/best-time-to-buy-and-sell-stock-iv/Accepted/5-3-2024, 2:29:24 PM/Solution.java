// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        int[][] dp = new int[len+1][2*k+1];
        for(int i=0; i<=len; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE/2);
        }

        
        dp[1][0] = 0; // 沒買過股票的profit==0
        dp[1][1] = -prices[0]; // 第一天買股票的profit== -price

        for(int i=2;i<=len; i++){ //從第二天開始遞推
            dp[i][0] = 0; // 沒買過股票的profit==0
            for(int a=1; a<=2*k; a++){
                
                if(a%2==1) // a%2==1:有買股票
                    dp[i][a] = Math.max(dp[i-1][a], dp[i-1][a-1]-prices[i-1]);
                else //  a%2==0 賣掉了
                    dp[i][a] = Math.max(dp[i-1][a], dp[i-1][a-1]+prices[i-1]);
            }
        }

        int max= 0 ;
        for(int a=1;a<=2*k; a++){
            max = Math.max(max, dp[len][a]);
        }

        return max;
    }
}