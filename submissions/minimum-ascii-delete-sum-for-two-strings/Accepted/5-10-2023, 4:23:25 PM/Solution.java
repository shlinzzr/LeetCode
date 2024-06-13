// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m+1][n+1];

        s1 = "#"+s1;
        s2 = "#"+s2;
        
        

        // init
        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j-1]+s2.charAt(j);
        
        for (int i = 1; i <= m; i++) 
            dp[i][0] = dp[i-1][0]+s1.charAt(i);
        
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = dp[i-1][j-1];
                else 
                    dp[i][j] = Math.min(dp[i-1][j]+s1.charAt(i), dp[i][j-1]+s2.charAt(j));
            }
        }
        return dp[m][n];
    }
}