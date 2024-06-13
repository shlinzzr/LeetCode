// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        
        if(n==0) return 1;
        
        int sign = x<0 ? -1 : 1;
        
        if(n%2==0){
            return myPow(x*x, n/2);
        }else 
            return sign*x*myPow(x*x, n/2);
        
    }
}