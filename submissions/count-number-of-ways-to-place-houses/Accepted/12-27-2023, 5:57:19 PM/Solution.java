// https://leetcode.com/problems/count-number-of-ways-to-place-houses

class Solution {
    public int countHousePlacements(int n) {
        int M = (int) 1e9+7;

        // 1. 題目看不懂
        // 2. 初始條件
        // 3. house robber 變形 要的是排列數
        

        long[][] dp = new long[n+1][2];
        dp[0][0] = 1; //不蓋房子也是一個答案
        // dp[0][1] = 0; 

        for(int i=1; i<=n; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][0]%=M;
            dp[i][1] = dp[i-1][0];
            dp[i][1]%=M;
        }

        long res = ((dp[n][0] + dp[n][1])%M);

        return (int)(res * res %M);

    }
}