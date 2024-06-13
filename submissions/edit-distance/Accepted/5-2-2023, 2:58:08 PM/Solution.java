// https://leetcode.com/problems/edit-distance

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++)
            dp[i][0] = i;
        
        for(int j = 0; j <= n; j++)
            dp[0][j] = j;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int a = dp[i-1][j-1];
                    int b = dp[i-1][j];
                    int c = dp[i][j-1];
                    
                    // find min
                    dp[i][j] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    dp[i][j]++;
                }
            }
        }
        return dp[m][n];
    }
}