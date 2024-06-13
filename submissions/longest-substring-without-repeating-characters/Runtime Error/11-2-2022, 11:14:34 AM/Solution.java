// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[256];
        
        int st=0, max=0;
        for(int i=0; i<s.length(); i++){
            char c  = s.charAt(i);
            
            if(arr[c-'a']==0)
                arr[c-'a']++;
            else{
                arr = new int[26];
                arr[c-'a']++;
                max = Math.max(max, i-st);
                st=i;
            }
            
        }
        
        return max;
    }
}