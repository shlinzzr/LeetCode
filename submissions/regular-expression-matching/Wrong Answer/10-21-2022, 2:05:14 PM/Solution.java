// https://leetcode.com/problems/regular-expression-matching

class Solution {
    
    int len_s;
    int len_p;
    String s;
    String p;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        
        this.s=s;
        this.p=p;
        len_s = s.length();
        len_p = p.length();
        
        dp = new Boolean[len_s][len_p];
        
        
        return dfs(0,0);
        
        
    }
    
    
    private boolean dfs(int i, int j){
        // System.out.println(i+","+j);
        
        if(i>=len_s && j>=len_p)
            return true;
        
        if(j>=len_p)
            return false;
        
         if(dp[i][j]!=null)
            return dp[i][j];
        
        boolean match = i<len_s && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<len_p && p.charAt(j+1)=='*'){
            boolean res = (match && dfs(i+1, j)) || dfs(i, j+2);
            dp[i][j] = res;
            return res;
        }
        
        if( match ){
            boolean res = dfs(i+1, j+1);
            dp[i][j] = res;
            return true;
        }
        
        
        dp[i][j] = false;
        return false;
    }
}