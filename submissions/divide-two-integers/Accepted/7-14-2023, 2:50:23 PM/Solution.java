// https://leetcode.com/problems/divide-two-integers

class Solution {
    public int divide(int dividend, int divisor) {
     
        // huifeng wodage https://www.youtube.com/watch?v=ZDqsq648i8c
        
        long a = dividend;
        long b = divisor;
        boolean sign = (a>0==b>0) ? false : true;
        
        long res =0;
        
        a = Math.abs(a);
        b = Math.abs(b);
        
        
        
        while(a>=b){
            long c = b;
            long cnt = 1;
            
            while((c<<1)<=a){
                c = c<<1;
                cnt = cnt <<1;
            }
            a-=c;
            res+=cnt;
        }
        
        if(sign)
            return (int)-res;
        
        if(res >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        return (int)res;
        
    }
}