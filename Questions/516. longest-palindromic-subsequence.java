// https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {

    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new int[n][n];
        return helper(0, s.length()-1, s);
    }

    private int helper(int left, int right, String s){

        if(left==right) return 1; 
        if(left>right) return 0;

        if(memo[left][right]!=0)
            return memo[left][right];

        if(s.charAt(left)==s.charAt(right))
            return 2 + helper(left+1, right-1, s);
        
        int max = Math.max(helper(left+1, right, s), helper(left, right-1, s));
        memo[left][right]=max;
        return max;
    }
}