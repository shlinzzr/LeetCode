// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {

        if(s.length()==0)
            return true;

        int idx = 0;
        for(int i=0; i<t.length(); i++){

            if(s.charAt(idx) == t.charAt(i)){
                idx++;
            }

            if(idx==s.length())
                return true;

        }

        return false;
    }
}