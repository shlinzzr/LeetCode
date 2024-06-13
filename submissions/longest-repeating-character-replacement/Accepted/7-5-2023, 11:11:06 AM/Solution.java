// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        
        int len = s.length();
        int res = 0;
        
        int max =0;
        
        int st= 0;
        
        int[] arr = new int[26];
        
        
        for(int ed= 0; ed<len; ed++){
            
            int idx = s.charAt(ed)-'A';
            
            arr[idx]++;
            
            max = Math.max(max, arr[idx]);
            
            while(ed-st+1-max>k){
                arr[s.charAt(st)-'A']--;
                st++;
            }
            
            res = Math.max(res, ed-st+1);
            
        }
        
        return res;
        
        
        
    }
}