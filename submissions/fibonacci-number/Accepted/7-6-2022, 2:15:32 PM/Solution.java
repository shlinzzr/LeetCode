// https://leetcode.com/problems/fibonacci-number

class Solution {
    public int fib(int n) {
        
        
        // recurisive
//         if(n<2)
//             return n;
//         else{
//             return fib(n-1) +  fib(n-2);
//         }
        
        
        if(n<2)
            return n;
        
        int a=0, b=1, res=0;
        
        for(int i=2; i<=n;i++){
            res=a+b;
            a=b;
            b=res;
            
            
        }
        return res;
        
    }
}