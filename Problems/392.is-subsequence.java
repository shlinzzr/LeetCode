// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length()==0) return true;
        
        int si = 0;
        for(int i=0; i<t.length(); i++){
            
            
            if(t.charAt(i)==s.charAt(si)){
                si++;
            }
            if(si==s.length() ) return true;
        }
        
        return si==s.length();
        
    }
}