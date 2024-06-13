// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences

class Solution {
    public int maximumLengthSubstring(String s) {
        
        int res = 0;
        
        int[]arr = new int[26];
        
        int st = 0;
        for(int ed=0; ed<s.length(); ed++){
            
            char ch = s.charAt(ed);
            arr[ch-'a']++;
            while(arr[ch-'a']>2){
                char chh = s.charAt(st);
                arr[chh-'a']--;
                st++;
            }
            
            res = Math.max(res, ed-st+1);
            
        }
        
        return res;
        
        
    }
}