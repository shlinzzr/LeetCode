// https://leetcode.com/problems/percentage-of-letter-in-string

class Solution {
    public int percentageLetter(String s, char letter) {
        int[] arr = new int[26];
        for(char c  : s.toCharArray()){
            arr[c-'a']++;
        }
        
        return  arr[letter-'a']*100 / s.length();
        // return Integer.parseInt(d)÷÷;
    }
}