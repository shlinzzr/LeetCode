// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        
        if(x<2) return x;
        int st= 1, ed=x/2;
        
        while(st<ed){
            
            int mid = ed-(ed-st)/2;
            int p = myPow(mid, 2);
            if(p==x){
                return mid;
            }else if(p>x){
                ed = mid-1;
            }else{
                st = mid;
            }
        }
        
        return st;
    }
    
    
    private int myPow(int x, int n){
        
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