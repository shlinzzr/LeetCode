// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram

class Solution {
    public int minSteps(String s, String t) {
        int[] arr1 =new int[26];
        
        for(int i=0; i<s.length(); i++){
            arr1[s.charAt(i)-'a']++;
            arr1[t.charAt(i)-'a']--;
        }
        
        int pos=0;
        for(int a : arr1){
            if(a>0)
                pos+=a;
        }
        
        return pos;
        
    }
}