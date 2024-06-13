// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        
        
        long st =0, ed = x; 
        
        while(st<ed){
            
            long mid = st+(ed-st)/2;
            
            if(mid*mid==x){
                return (int) mid;
            }else if(mid*mid > x){
                ed = mid-1;
            }else{
                
                st = mid+1;
            }
        }
        long sq = st*st;
        if(sq > x)
            return (int)st-1;
        
        return  (int)st;
        
    }
}