// https://leetcode.com/problems/word-break

class Solution {

    // permutation => TLE
    
    boolean res ;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        res=false;
        helper(s, wordDict);
        
        return res;
    }
    
    
    private void helper(String s, List<String> wordDict){
        
        if(s.length()==0){
            res = true;
            return;
        }
        
        for(String w : wordDict){
            if(s.startsWith(w)){
                helper(s.substring(w.length(), s.length()), wordDict);
            }
        }
        
        
    }
    
    
    
}