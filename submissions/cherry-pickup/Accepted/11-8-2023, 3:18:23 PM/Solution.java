// https://leetcode.com/problems/cherry-pickup

class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][] dp = new int[N+1][N+1][N+1];
        
        for (int i=0; i<=N; i++)
            for (int j=0; j<=N; j++)
                for (int x=0; x<=N; x++)
                    dp[i][j][x] = Integer.MIN_VALUE;
        
       

        for (int i=1; i<=N; i++)
            for (int j=1; j<=N; j++)
                for (int x=1; x<=N; x++){

                    int y = i+j-x;
                    if (y<1||y>N) 
                        continue;

                    if (grid[i-1][j-1]==-1||grid[x-1][y-1]==-1)
                        continue;

                    if (i==1&&j==1&&x==1){
                        dp[i][j][x] = grid[0][0];
                        continue;
                    }

                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i-1][j][x-1]);
                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j-1][x-1]);
                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i-1][j][x]);
                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j-1][x]);
                    
                    if (i==x && j==y)
                        dp[i][j][x] += grid[i-1][j-1];
                    else
                        dp[i][j][x] += grid[i-1][j-1] + grid[x-1][y-1];
                    
                }
        
        return Math.max(0,dp[N][N][N]);
        
    }
}