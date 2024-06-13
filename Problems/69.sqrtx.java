// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        
        if(x<2) return x;
        long st= 1, ed=x/2;
        
        while(st<ed){
            
            long mid = ed-(ed-st)/2;
            long p = mid*mid;
            if(p==x){
                return (int)mid;
            }else if(p>x){
                ed = mid-1;
            }else{
                st = mid;
            }
        }
        
        return (int)st;
    }
    
    
    private long myPow(long x, int n){
        
        if(n==0) return 1;
        
        if(n<0){
            n=-n;
            x=1/x;
        }
        
        if(n%2==0){
            return myPow(x*x, n/2);
        }else 
            return x*myPow(x*x, n/2);
        
    }
}