// https://leetcode.com/problems/minimum-path-sum

class Solution {
    public int minPathSum(int[][] grid) {
        int h= grid.length;
        int w= grid[0].length;
        
        
        
        int[][] dp = new int [h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(i>0 && j>0)
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                else if(i>0)
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                else if(j>0)
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                else 
                    dp[i][j] = grid[i][j];
            }
        }
        
//         for(int i=0; i<h; i++){
//             for(int j=0; j<w; j++){
//                 System.out.print(dp[i][j] + ", ");
//             }
            
//             System.out.println();
//         }
                
        
        
        return dp[h-1][w-1];
        
        
    }
}