// https://leetcode.com/problems/first-letter-to-appear-twice

class Solution {
    public char repeatedCharacter(String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            
            if(arr[c-'a']==0)
                arr[c-'a']++;
            else
                return c;
            
        }
        return 'a';
    }
    
    
}