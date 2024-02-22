// https://leetcode.com/problems/merge-strings-alternately

class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        int idx1 = 0;
        int idx2 = 0;
        
        
        StringBuilder sb = new StringBuilder();
        
        while(idx1<len1 && idx1<len2){
            
            sb.append(word1.charAt(idx1++));
            sb.append(word2.charAt(idx2++));
        }
        
        
        while(idx1<len1){
            sb.append(word1.charAt(idx1++));
        }
        
        while(idx2<len2){
            sb.append(word2.charAt(idx2++));
        }
        
        return sb.toString();
        
    }
}