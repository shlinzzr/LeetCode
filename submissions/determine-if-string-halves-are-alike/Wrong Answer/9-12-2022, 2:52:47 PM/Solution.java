// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        
        int[] arr = new int[100];
        
        int len=s.length(), cnt=0;
        
        for(char c : s.toCharArray()){
            if(cnt<len/2)
                arr[c-'A']++;
            else
                arr[c-'A']--;
            
            cnt++;
        }
        
        char[] ca = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        for(char c: ca){
            
            if(arr[c-'A']!=0)
                return false;
        }
        
        return true;
    }
}