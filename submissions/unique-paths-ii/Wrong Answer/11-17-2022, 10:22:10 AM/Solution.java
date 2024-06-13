// https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    
        
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0]==1   || obstacleGrid[h-1][w-1]==1 )
            return 0;
        
        
        
        
        int[][] dp = new int[h][w];
        
        for(int i=0; i<h; i++){
            dp[i][0]=1;
            if(obstacleGrid[i][0]==1)
               break;
        }
        
        for(int j=0; j<w; j++){
            dp[0][j]=1; 
            if(obstacleGrid[0][j]==1)
               break;
        }
        
        
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                
                if(obstacleGrid[i][j]==1)
                    continue;
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        
        
        return dp[h-1][w-1];
    }
}