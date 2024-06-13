// https://leetcode.com/problems/minimum-string-length-after-removing-substrings

class Solution {
    public int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")){
            s= s.replaceAll("AB", "");
            s= s.replaceAll("CD", "");
        }
        
        return s.length();
        
    }
}