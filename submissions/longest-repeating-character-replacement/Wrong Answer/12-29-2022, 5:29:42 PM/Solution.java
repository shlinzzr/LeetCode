// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] arr = new int[26];
        int maxCnt = 0;
        int maxLen = 0;
        
        int st=0;
        for(int ed=0; ed<s.length(); ed++){
            
            char c = s.charAt(ed);
            arr[c-'A']++;
            
            maxCnt = Math.max(maxCnt, arr[c-'A']);
            
            int strLen = ed-st+1;
            
            while(st<s.length() && strLen - maxCnt >k){
                arr[s.charAt(st)-'A']--;
                st++;
            }
            
            maxLen = Math.max(maxLen, ed-st+1);
            
            
        }
        
        
        return maxLen;
        
    }
}