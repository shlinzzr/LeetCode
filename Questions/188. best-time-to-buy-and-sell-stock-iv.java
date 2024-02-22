// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        int[] hold = new int[k+1];
        int[] sold = new int[k+1];
        Arrays.fill(hold, Integer.MIN_VALUE/2);
        Arrays.fill(sold, Integer.MIN_VALUE/2);
        hold[0] = -prices[0];
        sold[0] = 0;
    
        int max=0 ;
        for(int i=1; i<len; i++){
            
            hold[0] = Math.max(hold[0], sold[0]-prices[i]);

            for(int j=1; j<=k; j++){

                hold[j] = Math.max(hold[j], sold[j] - prices[i]);
                sold[j] = Math.max(sold[j], hold[j-1]+prices[i]);
                max= Math.max(max, sold[j]);
            }
        }

    

        return max;


    }
}