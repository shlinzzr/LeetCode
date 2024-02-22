// https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers

class Solution {
    public int numberOfWays(int n, int x) {
        
        int[][] dp = new int[305][305];
        
        int M = (int) 1e9+7;
        dp[0][0] = 1;
        
        for (int i=0; i<=n; i++)        
            for (int j=1; j<=n; j++)
            {
                dp[i][j] = dp[i][j-1];

                long num = 1;
                for (int t=0; t<x; t++)
                    num *= j;

                if (num <= i)
                {
                    dp[i][j] += dp[(int)(i-num)][j-1];
                    dp[i][j] %= M;
                }                
            }            
                        
        return dp[n][n];
        
    }
    
    
    
}