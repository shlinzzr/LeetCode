// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        
        if(n<=3) return n;
        
        int a=1;
        int b=1;
        int c=0;
        
        // 1 1 2 3 5
        // a+b=c
        //.  a b
        
        for(int i=2; i<=n; i++){
            c=a+b;
            a=b;
            b=c;
        }        
        
        return b;
        
    }
}