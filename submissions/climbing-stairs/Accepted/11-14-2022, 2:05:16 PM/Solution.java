// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        
        if(n<=3)
            return n;
        
        int a = 2;
        int b = 3;
        int c = 5;
        for(int i=4; i<=n; i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
        
        
    }
}