// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        
        int[] arr = new int[26]; 
        
        for(int i=0, j=0; i<s.length();i++){
            char c = s.charAt(i);
            
            if(arr[c-'a']>0){
                j = arr[c-'a'];
            }
            
            arr[c-'a'] =i;
            
            max = Math.max(max, i-j);
        }
        
        return max;
        
    }
}