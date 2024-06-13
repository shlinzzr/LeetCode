// https://leetcode.com/problems/longest-ideal-subsequence

class Solution {
    public int longestIdealString(String s, int k) {

        // s =  acfgbd, k=2

        // t = bcdfg

        // find the longest with distance < k

        int res= 0 ;
        int len = s.length();
        int[] dp = new int[150];
        // dp[1] = 1;

        for(int i=0; i<s.length(); i++){

            int ch = s.charAt(i);
            for (int j = ch - k; j <= ch + k; j++){
                dp[ch] = Math.max(dp[ch], dp[j]);
            }
            res = Math.max(res, ++dp[ch]);
        }
        

        return res;
        
    }
}