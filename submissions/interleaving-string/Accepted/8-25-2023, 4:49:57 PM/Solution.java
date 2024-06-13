// https://leetcode.com/problems/interleaving-string

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length())
            return false;
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        s1 = "#" + s1;
        s2 = "#" + s2;
        s3 = "#" + s3;
        
        for(int i=1; i<=m; i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i)==s3.charAt(i);
        }
        
        for(int j=1; j<=n; j++){
            dp[0][j] = dp[0][j-1] && s2.charAt(j)==s3.charAt(j);
        }

        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                
                
                
                
                dp[i][j] =  (dp[i-1][j] && s1.charAt(i)==s3.charAt(i+j)) 
                         || (dp[i][j-1] && s2.charAt(j)==s3.charAt(i+j) );
            }
        }
        
        return dp[m][n];
        
        
        
    }
}