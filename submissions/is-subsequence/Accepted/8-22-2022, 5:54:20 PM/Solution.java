// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length()==0)
            return true;
        
        int sidx = 0;
        for(int i=0; i<t.length(); i++){
            
            if(t.charAt(i)==s.charAt(sidx))
                sidx++;
            
            if(sidx==s.length())
                return true;
            
        }
        
        return sidx==s.length();
        
    }
}