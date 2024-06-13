// https://leetcode.com/problems/shortest-palindrome

class Solution {
    public String shortestPalindrome(String s) {

        int len = s.length();

        int[] next = new int[len];
        
        String pal = "";
        int max = 0 ;
        for(int j=0, i=1; i<len; i++){
            while(j>0 && s.charAt(j)!=s.charAt(i)){
                j = next[j-1];
            }

            if(s.charAt(j)==s.charAt(i)){
                j++;
            }

            next[i] = j;
        }

        int lc = next[len-1];

        return new StringBuilder(s.substring(lc)).reverse().toString()+s;
        
    }
}