// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
        // double d = 1;
        // if(x==1.00000)
        //     return x;
        
        if(n<0){
            x=1/x;
            n=-n;
        }
        
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
//         for(int i=0; i<n; i++){
//             d*=x;
//         }
        
//         return d;
        
    }
}