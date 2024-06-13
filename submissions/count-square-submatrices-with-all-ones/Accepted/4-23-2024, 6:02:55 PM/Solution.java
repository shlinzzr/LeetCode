// https://leetcode.com/problems/count-square-submatrices-with-all-ones

class Solution {
    public int countSquares(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        // dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        
        int[][] dp = new int[h][w];
        
        for(int i=0; i<h; i++){
            dp[i][0] = matrix[i][0];
        }
        
        for(int j=0; j<w; j++){
            dp[0][j] = matrix[0][j];
        }
        
        
        int res = 0 ;
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                
                if(matrix[i][j]==1){
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));    
                }
                res += dp[i][j];    
            }
        }
        
        for(int i=0; i<h; i++){
            res += dp[i][0];
        }
        
        for(int j=1; j<w; j++){
            res += dp[0][j];
        }
        
        return res;
        
        /*
        [[0,1,1,1]
        ,[1,1,1,1]
        ,[0,1,1,1]]
        
        [[0,1,1,1]
        ,[1,1,2,2]
        ,[0,1,2,3]]
        
        
        
        
        */
        
        
    }
}