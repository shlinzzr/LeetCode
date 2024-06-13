// https://leetcode.com/problems/divide-two-integers

class Solution {
    public int divide(int dividend, int divisor) {
        // use bit manipulation to replace mul

        long a = dividend;
        long b = divisor;

        long sign = (a>0==b>0) ? 1 : -1;

        a = Math.abs(a);
        b = Math.abs(b);

        long quotient = 0;

        while(a>=b){
            long c=b;
            long cnt=1;
            while((c<<1)<=a){
                c<<=1;
                cnt<<=1;
            }
            a-=c;
            quotient+=cnt;

        }

        if(sign==-1)
            return (int)-quotient;
        
        if(quotient >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return  (int)quotient;

        /*

        a/b = ? => a= b*2

        b*2
        b*4
        b*8
        b*16
        ...

        */







    }
}