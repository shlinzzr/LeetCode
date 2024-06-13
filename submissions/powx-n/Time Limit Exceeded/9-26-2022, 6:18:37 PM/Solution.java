// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1d;
        
        double base = x;
        if(n>0){
            
            while(n>1){
                x *= base;
                n--;
            }
            
            return x;
            
        }else{
            
            while(n<-1){
                x*=base;
                n++;
            }
            
            return 1/x;
        }
        
    }
}