// https://leetcode.com/problems/divide-two-integers

class Solution {
    public int divide(int dividend, int divisor) {
        
        return helper((long)dividend, (long)divisor);   
        
    }
    private int helper(long dividend, long divisor){
        int res = 0;
        
        if(dividend<0){
            dividend=-dividend;
            divisor = - divisor;
        }
        
        
        
        while(dividend>= Math.abs(divisor)){
            
            if(divisor>0){
                dividend-=divisor;
                res++;
                
            }else{
                dividend+=divisor;
                res--;
            }
        }
        
        return res;
    }
}