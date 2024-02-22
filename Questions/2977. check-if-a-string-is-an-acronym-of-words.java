// https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words

class Solution {
    public boolean isAcronym(List<String> words, String s) {
        
        if(words.size()!=s.length())
            return false;
        
        
        for(int i=0; i<words.size(); i++){
            
            String w = words.get(i);
            
            if(w.charAt(0)!=s.charAt(i))
                return false;
            
            
        }
        
        
        return true;
        
    }
}