// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx_s=0, idx_t=0;
        
        while(idx_s<s.length()){
            
            idx_t = t.indexOf(s.charAt(idx_s), idx_t );
            idx_s++;
            if(idx_t<0)
                return false;
            
        }
        return true;
    }
}