// https://leetcode.com/problems/wildcard-matching

class Solution {
    public boolean isMatch(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        
        boolean[][] dp = new boolean[s_len+1][p_len+1];
        
        // s : ""
        // p : "*****"
        if(s.isEmpty()){
            for(int j=1; j<=p_len; j++){
                if(p.charAt(j-1)!='*')
                    break;
                dp[0][j]=true;
            }
        }
        
        
        
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length();j++){
                
                if(p.charAt(j-1)=='?' || p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                    
                }else if(p.charAt(j-1)=='*'){
                    
                    for(int k=0; k<=i ; k++){
                        if(dp[k][j]==true)
                            dp[i][j]=true;
                    }
                    
                    // dp[i][j] = dp[i-1][j] || dp[]
                }
                
                
            }
        }
        
        return dp[s.length()][p.length()];
    }
}