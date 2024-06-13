// https://leetcode.com/problems/word-break

class Solution {

    // dp => 10ms
    
    boolean res ;
    public boolean wordBreak(String s, List<String> wordDict) {
       
        int len = s.length();
        boolean[] b = new boolean[len+1];
        b[0]=true;
        
        
        for(int i=1; i<=len; i++){
            for(int j=0; j<i; j++){
               if(b[j] && wordDict.contains(s.substring(j, i))){
                    b[i] = true;
                    break;
                }
            }
        }
        
        return b[len];
        
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