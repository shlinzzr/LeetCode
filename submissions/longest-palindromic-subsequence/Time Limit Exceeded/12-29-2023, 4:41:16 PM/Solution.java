// https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(0, s.length()-1, s);
    }

    private int helper(int left, int right, String s){

        if(left==right) return 1; 
        if(left>right) return 0;

        if(s.charAt(left)==s.charAt(right))
            return 2 + helper(left+1, right-1, s);
        
        return Math.max(helper(left+1, right, s), helper(left, right-1, s));
    }
}