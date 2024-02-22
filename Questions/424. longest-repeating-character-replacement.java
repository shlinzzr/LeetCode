// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        
        int maxLen = 0;
        int maxCnt = 0;
        
        int[] arr = new int[26];
        
        int st = 0;
        for(int ed=0; ed<len; ed++){
            
            int idx = s.charAt(ed)-'A';
            
            arr[idx]++;
            
            maxCnt = Math.max(maxCnt, arr[idx]);
            while(ed-st+1 - maxCnt >k){
                arr[s.charAt(st)-'A']--;
                st++;
            }
        
            
            maxLen = Math.max(maxLen, ed-st+1);
            
            
        }
        
        return maxLen;
        
    }
}