// https://leetcode.com/problems/number-of-music-playlists

class Solution {

    int M = (int) 1e9+7;

    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal+1][n+1];
        dp[0][0]=1;
        for(int i=1; i<=goal; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i-1][j-1] * (n-j+1); // 選不同首歌
                dp[i][j] += dp[i-1][j] * Math.max(0, j-k); //選同一首歌距離超過k
                dp[i][j]  %= M;
            }
        }

        return (int)dp[goal][n];
    }
}