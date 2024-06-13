// https://leetcode.com/problems/unique-paths

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] =1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                
                dp[i][j] = (i>1 ? dp[i-1][j] : 1) + (j>1 ? dp[i][j-1] : 1);
                
                
            }
        }
        
        return dp[m-1][n-1];
    }
}