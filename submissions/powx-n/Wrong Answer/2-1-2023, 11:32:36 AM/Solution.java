// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        
        double d = 1;
        
        if(x==1.00000)
            return x;
        
        if(n<0){
            x=1/x;
            n=-n;
        }
        
        
        for(int i=0; i<n; i++){
            d*=x;
        }
        
        return d;
        
    }
}