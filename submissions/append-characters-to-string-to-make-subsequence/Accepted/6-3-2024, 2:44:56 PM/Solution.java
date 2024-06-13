// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence

class Solution {
    public int appendCharacters(String s, String t) {
        
        
        int idx =0;
        for(int i=0; i<s.length(); i++){
            
            if(idx<t.length() && s.charAt(i)==t.charAt(idx))
                idx++;
        }
        
        return t.length()-idx;
    }
}