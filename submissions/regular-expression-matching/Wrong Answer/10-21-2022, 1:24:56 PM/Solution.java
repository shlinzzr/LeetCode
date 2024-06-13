// https://leetcode.com/problems/regular-expression-matching

class Solution {
    
    int len_s;
    int len_p;
    String s;
    String p;
    public boolean isMatch(String s, String p) {
        
        this.s=s;
        this.p=p;
        len_s = s.length();
        len_p = p.length();
        
        return dfs(0,0);
        
        
    }
    
    
    private boolean dfs(int i, int j){
        if(i>=len_s && j>=len_p)
            return true;
        
        if(j>=len_p)
            return false;
        
        boolean match = i<len_s && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if( dfs(i, j+2) || (match && dfs(i+1, j+1)))
            return true;
        
    
        return false;
    }
}