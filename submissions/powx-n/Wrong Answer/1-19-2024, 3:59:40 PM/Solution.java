// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        
        if(n==0) return 1;
        
        
        boolean sign=false;
        if(n<0){
            n=-n;
            sign=true;
        }
        
        if(n%2==0){
            
            if(sign)
                return 1/myPow(x*x, n/2);
            else
                return myPow(x*x, n/2);
        }else {
            
            if(sign)
                return 1/x*myPow(x*x, n/2);
            else
                return  x*myPow(x*x, n/2);
        }
        
    }
}