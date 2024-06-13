// https://leetcode.com/problems/word-break-ii

class Solution {
    
    List<String> res ;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        helper(s, wordDict, new ArrayList<>());
        return res;
    }
    
    
    private void helper(String s, List<String> wordDict, List<String> curr){
        
        if(s.length()==0){
            StringBuilder sb = new StringBuilder();
            for(String c : curr) 
            {sb.append(c); sb.append(" ");}
            sb.deleteCharAt(sb.length()-1);
            
            res.add(sb.toString());
        }
        
        for(String w : wordDict){
            if(s.startsWith(w)){
                curr.add(w);
                helper(s.substring(w.length(), s.length()), wordDict, curr);
                curr.remove(curr.size()-1);
            }
        }
        
    }
}