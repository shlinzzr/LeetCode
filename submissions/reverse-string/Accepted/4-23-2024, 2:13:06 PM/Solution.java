// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        
        int len = s.length;
        
        for(int i=0; i<len/2; i++){
            swap(s, i, len-i-1);
        }
        
    }
    
    private void swap(char[] s, int a, int b){
        
        char t = s[a];
        s[a] = s[b];
        s[b] = t;
    }
}