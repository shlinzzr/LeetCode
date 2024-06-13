// https://leetcode.com/problems/solving-questions-with-brainpower

class Solution {
    public long mostPoints(int[][] Q) {
        int len = Q.length;
        
        int[] dp = new int[len+1];
        
        for (int i=len-1; i>=0; i--)
        {
            int j = i+Q[i][1]+1;            
            dp[i] = Math.max(dp[i+1], (j<len?dp[j]:0) + Q[i][0]);
        }
        return dp[0];
    }
    
}