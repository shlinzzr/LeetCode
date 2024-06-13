// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String h, String n) {
        
        
        int wLen = n.length();
        for(int i=0; i<h.length(); i++ ){
            if(h.substring(i, i+wLen).equals(n)) return i;
        }
        
        return -1;
        
        
        
    }
}