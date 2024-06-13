// https://leetcode.com/problems/regular-expression-matching

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m+1][n+1];
        //1. normal || '.' 
        //2. '*'  2a: match 0, 2b: recur
        
        dp[0][0]=true;
        
        //initialize
        for(int j=2; j<=n; j++){
            if(p.charAt(j-1)=='*')
                dp[0][j] = dp[0][j-2];
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                
                char cs = s.charAt(i-1);
                char cp = p.charAt(j-1);
                
                if(cs==cp || cp=='.'){
                    dp[i][j] = dp[i-1][j-1];
                    
                }else if(cp=='*'){
                    
                    if(dp[i][j-2]){
                        dp[i][j]=true;
                    
                    
                    // if(p.charAt(j-1)==s.charAt(i-1)){
                    //     dp[i][j] = dp[i-1][j];
                    }else if(cs == p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
        
        
        
    }
}