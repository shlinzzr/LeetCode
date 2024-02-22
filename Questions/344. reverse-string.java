// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int st=0, ed=len-1;
        while(st<ed){
            char t = s[st];
            s[st] = s[ed];
            s[ed] = t;
            st++;
            ed--;
        }
    }
}