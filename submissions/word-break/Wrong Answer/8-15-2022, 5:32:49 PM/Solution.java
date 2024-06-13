// https://leetcode.com/problems/word-break

class Solution {
    
    boolean res = false;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        
        backtrack(s, wordDict);
        
        return res;
        
    }
    
    private void backtrack(String s, List<String> wordDict){
        
        if(s.isEmpty()){
            res = true;
            return;
        }
            
        boolean isContain=false;
        for(String w : wordDict){
            if(s.contains(w)){
                isContain= true;
                String tmp = s.replace(w, "");
                backtrack(tmp, wordDict); 
            }
        }
        if(isContain==false)
            return;
        
    }
    
}