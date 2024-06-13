// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        
//         if(n<=3)
//              return n;
        
//         int[] dp = new int[n+1];
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;
//         dp[3] = 3;
        
        
//         for(int i=4; i<=n; i++){
//             dp[i] = dp[i-1]+dp[i-2];
//         }
        
//         return dp[n];
        
        int  a=2, b=3, res=0;
        
        for(int i=4; i<=n; i++){
            res=a+b;
            a=b;
            b=res;
        }
        
        return res;
        
        
        
    }
}