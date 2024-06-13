// https://leetcode.com/problems/longest-ideal-subsequence

class Solution {
    public int longestIdealString(String s, int k) {

        // s =  acfgbd, k=2

        // t = bcdfg

        // find the longest with distance < k

        char[] arr = s.toCharArray();

        int[] dp = new int[arr.length+1];
        dp[1] = 1;


        for(int i=2; i<=arr.length; i++){

            dp[i] = dp[i-1];
            for(int j=i-1; j>0; j--){ // j=1

                if(Math.abs(s.charAt(j-1)-s.charAt(i-1))<=k)
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        return dp[arr.length];
        
    }
}