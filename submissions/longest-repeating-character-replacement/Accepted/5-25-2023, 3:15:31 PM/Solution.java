// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        
        // neetcode https://www.youtube.com/watch?v=gqXU1UyA8pk
        
        int len = s.length();
        int[] arr = new int[26];
        
        int maxCnt =0;
        int maxLen=0;
        int st =0;
        for(int ed=0; ed<len; ed++){
            
            char ch = s.charAt(ed);
            arr[ch-'A']++;
            
            maxCnt = Math.max(maxCnt, arr[ch-'A']);
            
            while(ed-st+1-maxCnt>k){
                arr[s.charAt(st)-'A']--;
                st++;
            }
            
            maxLen = Math.max(maxLen, ed-st+1);
        }
        
        return maxLen;
      
        
        
        
    }
}