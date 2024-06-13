// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        int cnt=0;
        int i=1;
        int s=x;
        while(s-i>=0){
            s = s - i ;
            cnt++;
            i = i +2;
            
        }
        
        return cnt;
            
    }
}