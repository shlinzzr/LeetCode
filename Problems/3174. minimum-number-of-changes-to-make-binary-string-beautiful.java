// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful

class Solution {
    public int minChanges(String s) {
        
        
        int res = 0;
        int len = s.length();
        for(int i=0; i<len; i+=2){
            if(s.charAt(i)!=s.charAt(i+1))
                res++;
        }
        
        return res;
        
    }
}