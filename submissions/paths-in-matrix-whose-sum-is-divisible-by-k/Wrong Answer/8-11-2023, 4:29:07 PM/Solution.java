// https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k

class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int h = grid.length;
        int w = grid[0].length;
       
         
        // dp[i][j][r] :  the number of distinct paths whose  sum % k ==r 
        
        int[][][] dp = new int[h+1][w+1][k]; 

        
        long sum = 0;
        for (int i=0; i<h; i++)
        {
            sum += grid[i][0];
            sum %= k;
            dp[i][0][(int)sum] = 1;
        }
        
        sum = 0;
        for (int j=0; j<w; j++)
        {
            sum += grid[0][j];
            sum %= k;
            dp[0][j][(int)sum] = 1;
        }
        
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                for(int r=0; r<k; r++){
                    
                    // dp[i][j][r] = dp[i-1][j][t] + dp[i][j-1][t];
                    // (t+grid[i][j]) %k = r
                    
                    int t = ((r-grid[i][j])%k + k)%k;
                    dp[i][j][r] = dp[i-1][j][t] + dp[i][j-1][t];
                }
            }
        }
        
        
        return dp[h-1][w-1][0];
    }
}