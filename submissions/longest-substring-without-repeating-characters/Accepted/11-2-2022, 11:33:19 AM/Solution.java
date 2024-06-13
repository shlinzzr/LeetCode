// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        
        Arrays.fill(arr, -1);
        
        int st=0, max=0;
        for(int i=0; i<s.length(); i++){
            char c  = s.charAt(i);
            
            if(arr[c]>=0){
                st = Math.max(st, arr[c]+1);
            }
            max = Math.max(max, i-st+1);
            arr[c] = i;
        }
        
        
        
        return max;
    }
}