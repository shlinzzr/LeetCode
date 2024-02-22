// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        
        int eq =0;
        for(int i=0; i<26; i++){
            if(arr[i]==0)
                continue;
            if(eq==0)
                eq=arr[i];
            if(arr[i]!=eq)
                return false;
                
        }
        
        return true;
    }
}