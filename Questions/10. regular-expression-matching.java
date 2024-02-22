// https://leetcode.com/problems/regular-expression-matching

class Solution {
    public boolean isMatch(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        
        boolean[][] dp = new boolean[s_len+1][p_len+1];
        dp[0][0]=true;
    
        for(int j=2; j<=p_len; j++){
            if(p.charAt(j-1)=='*')
                dp[0][j]=dp[0][j-2];
        }
        
        
        
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length();j++){
                
                if(p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                    
                }else if(p.charAt(j-1)=='*'){
                    
                    if(dp[i][j-2]) // choose 0 char ,ignore last 2 pattern
                        dp[i][j]=true;

                    else if(p.charAt(j-2)=='.' || p.charAt(j-2)==s.charAt(i-1)){
                        dp[i][j] = dp[i-1][j];
                    }
                }
                
                
            }
        }
        
        return dp[s.length()][p.length()];
    }
}