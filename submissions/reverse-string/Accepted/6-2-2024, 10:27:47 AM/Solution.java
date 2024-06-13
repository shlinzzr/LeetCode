// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        int st = 0, ed=s.length-1;
        char[] arr =s;
        while(st<ed){
            char t = arr[st];
            arr[st] = arr[ed];
            arr[ed] = t;
            st++;
            ed--;
        }    
    }


}