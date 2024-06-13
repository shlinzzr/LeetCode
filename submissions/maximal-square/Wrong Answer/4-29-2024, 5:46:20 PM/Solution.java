// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int[][] dp = new int[h][w];
        
        for(int i=0; i<h; i++){
            dp[i][0] = i==0 ? (matrix[0][0]=='0' ? 0 : 1) :(matrix[i][0]=='0' ? 0 : dp[i-1][0] + 1);
        }
        
        for(int j=1; j<w; j++){
            dp[0][j] = (matrix[0][j]=='0' ? 0 : dp[0][j-1] + 1);
        }
        
        
        int max= 0 ;
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                
                if(matrix[i][j]=='1'){
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1]));    
                     max = Math.max(max, dp[i][j]);
                }
                
                
                // System.out.print(dp[i][j] + " ,");
               
                
            }
            
            // System.out.println();
        }
        
        return max * max;
        
    }
}