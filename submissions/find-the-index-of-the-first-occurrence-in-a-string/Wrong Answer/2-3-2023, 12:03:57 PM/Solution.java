// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        
        int len = haystack.length();
        int nl = needle.length();
        for(int i=0;i<len-nl; i++){
            
            if(haystack.charAt(i)==needle.charAt(0)){
                
                if(haystack.substring(i, i+nl).equals(needle))
                    return i;
            }
            
        }
        
        return -1;
        
    }
}