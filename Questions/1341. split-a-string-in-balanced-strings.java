// https://leetcode.com/problems/split-a-string-in-balanced-strings

class Solution {
    public int balancedStringSplit(String s) {
        
        int cnt = 0;
        int res = 0;
        for(char c : s.toCharArray()){
            
            if(c=='R')
                cnt++;
            else
                cnt--;
            
            if(cnt==0)
                res++;
            
        }
        return res;
    }
}