// https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] dp = new int[h][w];
        
        for(int i=0; i<h; i++){
            
            if(grid[i][0]==1)
                break;
            
            dp[i][0]=1;
        }
        
        for(int j=0; j<w; j++){
            
            if(grid[0][j]==1)
                break;
            
            dp[0][j]=1;
        }
        
        
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                
                if(grid[i][j]==1)
                    dp[i][j]=0;
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
                
            }
        }
        
        return dp[h-1][w-1];
        
    }
}
