// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        
        int[] arr = new int[26];
        
        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            arr[cs-'a']++;
            arr[ct-'a']--;
        }
        
        for(int i : arr){
            if(i!=0)
                return false;
        }
        
        return true;
    }
}