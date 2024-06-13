// https://leetcode.com/problems/minimum-falling-path-sum

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        int[][] dp = new int[h][w+2];
        
        
        for(int i=0; i<h; i++){
            
            
            dp[i][0]=Integer.MAX_VALUE;
            dp[i][w+1]=Integer.MAX_VALUE;
            
            
            for(int j=1; j<w+1; j++){
                
                if(i==0){
                    dp[i][j]=matrix[0][j-1];    
                    continue;
                }
                
                dp[i][j] += Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]))+ matrix[i][j-1];
            }
        }
        
        
        int res = Integer.MAX_VALUE;
        
        for(int j=1; j<w+2;j++){
            res = Math.min(res, dp[h-1][j]);
        }
        
        
        
        return res;
            
        
    }
}