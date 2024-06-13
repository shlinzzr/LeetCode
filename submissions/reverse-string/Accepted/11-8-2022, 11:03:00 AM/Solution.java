// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        
        int st=0, ed=s.length-1;
        while(st<ed){
            
            char c = s[st];
            s[st] = s[ed];
            s[ed] = c;
            st++;
            ed--;
        }
        
    }
}