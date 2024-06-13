// https://leetcode.com/problems/distinct-subsequences-ii

class Solution {
    public int distinctSubseqII(String s) {
        int M = (int) 1e9+7;
        int N = s.length();

        // int[][] dp = new int[N+1][26]; // 走到第i位數字時的以j為結尾的 distinct subseq cnt

        // 因為dp[i] 完全依賴於 dp[i-1]於是可以把dp[i]省略 剩下dp[26]

        int[] dp = new int[26];

        for(int i=0; i<N; i++){
            dp[s.charAt(i)-'a'] = 1 + sumUp(dp); 
        }

        return sumUp(dp);

    }

    private int sumUp(int[] dp){
        int res = 0;
        for(int i=0; i<26; i++){
            res += dp[i];
        }
        return res;
    }
}