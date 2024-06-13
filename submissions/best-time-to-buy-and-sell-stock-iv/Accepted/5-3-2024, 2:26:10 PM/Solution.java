// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        int[][] dp = new int[len+1][2*k+1];
        for(int i=0; i<=len; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE/2);
        }
        // dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for(int i=2;i<=len; i++){
            dp[i][0] = 0;
            for(int a=1; a<=2*k; a++){
                
                if(a%2==1)
                    dp[i][a] = Math.max(dp[i-1][a], dp[i-1][a-1]-prices[i-1]);
                else
                    dp[i][a] = Math.max(dp[i-1][a], dp[i-1][a-1]+prices[i-1]);
            }
        }

        int max= 0 ;

        for(int a=1;a<=2*k; a++){
            System.out.println(a + " " + dp[len][a]);
            max = Math.max(max, dp[len][a]);
        }

        return max;
    }
}