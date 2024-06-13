// https://leetcode.com/problems/merge-strings-alternately

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int idx1 = 0;
        int idx2 = 0;
        
        String res = "";
        while(idx1<len1 || idx2<len2){
            
            if(idx1<len1)
                res += word1.charAt(idx1++);
            
            if(idx2<len2)
                res += word2.charAt(idx2++);
            
        }
        
        return res;
    }
}