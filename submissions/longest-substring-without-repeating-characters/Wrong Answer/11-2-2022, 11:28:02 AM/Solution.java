// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        
        Arrays.fill(arr, -1);
        
        int st=0, max=0;
        for(int i=0; i<s.length(); i++){
            char c  = s.charAt(i);
            
            if(arr[c]>=0){
                st = arr[c];
            }
            max = Math.max(max, i-st);
            arr[c] = i;
        }
        
        int t=0;
        for(int a : arr){
            if(a>=0)
                t++;
        }
        max = Math.max(max, t);
        
        
        return max;
    }
}