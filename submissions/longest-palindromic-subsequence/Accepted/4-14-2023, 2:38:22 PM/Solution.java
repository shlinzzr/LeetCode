// https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        
//          X X X X j X X X i => dp[i][j];
//         dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
//         State transition:
//         dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
//         otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
        
        
        int N = s.length();
        
        s="#"+s; // s offset
        
        
        int[][] dp = new int[N+1][N+1];
        for(int i=0; i<=N; i++)
            dp[i][i] = 1; // all the single character must be palindrome; 
        
        for(int len=2; len<=N; len++){ //長度從2開始到N(includsive), 因為單字符必定為palindrome
            for(int i=1; i<=N-len+1; i++){ //讓i從1開始 因為s有offset
                int j = i+len-1;
                
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j]= Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[1][N];
        
        
        
//         for(int i=0; i<s.length(); i++){
//             dp[i][i] = 1; // all the single character must be palindrome; 
            
//             for (int j = i+1; j < s.length(); j++) {
//                 if (s.charAt(i) == s.charAt(j)) {
//                     dp[i][j] = dp[i+1][j-1] + 2;
//                 } else {
//                     dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[0][s.length()-1];
    }
}