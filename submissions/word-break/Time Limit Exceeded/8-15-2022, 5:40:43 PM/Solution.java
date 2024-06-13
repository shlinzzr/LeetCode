// https://leetcode.com/problems/word-break

class Solution {
    
    boolean res = false;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // String aa = "__";
        // aa.replace("_", "bb");
        // System.out.println(aa);
        
        backtrack(s, wordDict);
        
        return res;
        
    }
    
    private void backtrack(String s, List<String> wordDict){
        System.out.println(s);
        if(s.isEmpty()|| s.replaceAll("_", "").isEmpty()){
            res = true;
            return;
        }
            
        boolean isContain=false;
        for(String w : wordDict){
            if(s.contains(w)){
                isContain= true;
                String tmp = s.replaceFirst(w, "__");
                backtrack(tmp, wordDict); 
            }
        }
        if(isContain==false)
            return;
        
    }
    
}