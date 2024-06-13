// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;
        
        if(!haystack.contains(needle))
            return -1;
        else{
            
            return haystack.indexOf(needle);
            
        }
    }
}