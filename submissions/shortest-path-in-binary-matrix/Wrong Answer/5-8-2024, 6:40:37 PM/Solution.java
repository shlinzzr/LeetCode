// https://leetcode.com/problems/shortest-path-in-binary-matrix

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0]==1) return -1;
        
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] dp = new int[h+1][w+1];
        for(int i=0; i<=h; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        
        for(int i=1; i<=h; i++){
            for(int j=1; j<=w; j++){
                
                if(grid[i-1][j-1]==1) continue;
                
                dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                
            }
        }
        
        return dp[h][w] == Integer.MAX_VALUE ? -1 : dp[h][w];
        
        
    }
}