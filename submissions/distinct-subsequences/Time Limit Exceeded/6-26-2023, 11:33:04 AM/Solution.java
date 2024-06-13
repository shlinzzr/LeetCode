// https://leetcode.com/problems/distinct-subsequences

class Solution {
    
     int res = 0;
    
    public int numDistinct(String s, String t) {
        
        helper(s, t, 0, 0);
        return res;
    }
    
    
    private void helper(String s,  String t, int s_idx, int t_idx){
        
        if(t_idx==t.length()){
            res++;
            return ;
        }
            
        
        for(int i=s_idx; i<s.length(); i++){
            
            if(s.charAt(i)==t.charAt(t_idx)){
                helper(s, t, i+1, t_idx+1);
            }
        }
    }
    
    
    
    
    
}