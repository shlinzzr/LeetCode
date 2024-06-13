// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        int[][] hold = new int[len][k+1];
        int[][] sold = new int[len][k+1];
        for(int i=0; i<len; i++){
            Arrays.fill(hold[i], Integer.MIN_VALUE/2);
        }
        
        // Arrays.fill(sold, Integer.MIN_VALUE/2);
        hold[0][0] = -prices[0];
        sold[0][0] = 0;
    
        int max=0 ;
        for(int i=1; i<len; i++){
            
            hold[i][0] = Math.max(hold[i][0], sold[i][0]-prices[i]);

            for(int j=1; j<=k; j++){

                hold[i][j] = Math.max(hold[i-1][j], sold[i-1][j] - prices[i]);
                sold[i][j] = Math.max(sold[i-1][j], hold[i-1][j-1]+prices[i]);
                max= Math.max(max, sold[i][j]);
            }
        }

    

        return max;


    }
}