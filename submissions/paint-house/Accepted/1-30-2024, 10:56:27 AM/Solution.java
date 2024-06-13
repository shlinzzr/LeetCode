// https://leetcode.com/problems/paint-house

class Solution {
    public int minCost(int[][] costs) {
        // 0:red, 1:blue, 2:green
        int len = costs.length;
        int[] dp = new int[3];
//https://www.youtube.com/watch?v=-w67-4tnH5U&t=912s
        for(int i=0; i<len; i++){
            int dp0 = costs[i][0] + Math.min(dp[1], dp[2]);
            int dp1 = costs[i][1] + Math.min(dp[0], dp[2]);
            int dp2 = costs[i][2] + Math.min(dp[0], dp[1]);
            dp[0] = dp0;
            dp[1] = dp1;
            dp[2] = dp2;
        }

        int min =Integer.MAX_VALUE; 
        for(int j=0; j<3; j++){
            min = Math.min(dp[j], min);
        }
        

        return  min;

    }
}