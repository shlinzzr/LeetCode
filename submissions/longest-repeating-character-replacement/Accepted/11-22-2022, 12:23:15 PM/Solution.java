// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        
        int maxCnt=0, maxLen=0;
        int[] arr = new int[26];
        
        int start =0;
        for(int end=0; end<s.length(); end++){
            
            maxCnt = Math.max(maxCnt, ++arr[s.charAt(end)-'A']);
            
            while(end-start+1 - maxCnt >k){
                arr[s.charAt(start)-'A']--;
                start++;
            }
            
            maxLen = Math.max(maxLen, end-start+1);
            
        }
        
        return maxLen;
        
        
    }
}