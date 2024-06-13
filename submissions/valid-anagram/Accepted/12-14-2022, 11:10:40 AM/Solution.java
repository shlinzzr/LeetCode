// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        
        for(char ch : t.toCharArray()){
            arr[ch-'a']--;
        }
        
        for(int a : arr){
            if(a!=0)
                return false;
        }
        
        return true;
    }
}