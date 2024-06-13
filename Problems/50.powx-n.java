// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {

        if(n==0) return 1;
        if(n==1) return x;

        // n == -2147483648 多做一次
        // 要在 reverse前先做 不然會溢出
        if(n==Integer.MIN_VALUE){ 
            x = x*x;
            n =n/2;   
        }


        // reverse
        if(n<0){
            n=-n;
            x = 1/x;
        }

    
       


        if(n%2==0){
            return myPow(x*x, n/2);
        }else{
            return x * myPow( x*x ,n/2);
        }



    }
}