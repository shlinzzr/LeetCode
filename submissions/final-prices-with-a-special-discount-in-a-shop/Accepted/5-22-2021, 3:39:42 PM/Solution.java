// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop

class Solution {
    public int[] finalPrices(int[] prices) {
        int siz = prices.length;
        
        int[] out = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            
            out[i]=prices[i];
            
            for(int j=i+1; j<prices.length; j++){
                
                if(prices[j]<=prices[i]){
                    out[i]=out[i]-prices[j];
                    break;
                }
                
                
            }
            
            
        }
        return out;
        
    }
}