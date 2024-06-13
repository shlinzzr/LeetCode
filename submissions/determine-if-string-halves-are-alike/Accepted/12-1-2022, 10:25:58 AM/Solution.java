// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        char[] dict = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        int len = s.length();
        String a = s.substring(0, len/2);
        String b = s.substring(len/2, len);
        int[] arr = new int[128];
        
        for(char c : a.toCharArray()){
            arr[c-'A']++;
        }
        
        for(char c : b.toCharArray()){
            arr[c-'A']--;
        }
        int total = 0;
        for(char c : dict){
            if(arr[c-'A']!=0){
                total+=arr[c-'A'];
                // return false;
            }
                
        }
        
        
        
        
        return total==0;
        
    }
}