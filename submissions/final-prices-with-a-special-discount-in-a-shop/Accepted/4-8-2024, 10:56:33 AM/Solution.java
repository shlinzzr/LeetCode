// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop

class Solution {
    public int[] finalPrices(int[] prices) {


        int len = prices.length;
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            
            int min = prices[i];
            int discount = 0;
            for(int j=i+1; j<len; j++){
                if(prices[j]<=prices[i]){
                    discount = prices[j];
                    break;
                }
            }
            res[i]= prices[i] - discount;


        }

        return res;
        
    }
}