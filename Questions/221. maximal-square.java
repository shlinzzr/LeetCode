// https://leetcode.com/problems/maximal-square

class Solution {
    
    public int maximalSquare(char[][] matrix) {
        
        int max = 0;
        int h=matrix.length;
        int w=matrix[0].length;
        
        int[][] dp = new int[h][w];
        
        for(int i=h-1; i>=0; i--){
            for(int j=w-1; j>=0; j--){
                
                if(matrix[i][j]=='0')
                    continue;
                
                if(i==h-1 || j==w-1)
                    dp[i][j] = 1;
                
                else if(dp[i][j+1]>0 && dp[i+1][j]>0 && dp[i+1][j+1]>0){
                    dp[i][j] =  Math.min(dp[i][j+1], Math.min(dp[i+1][j+1], dp[i+1][j]))+1;
                }else
                    dp[i][j] = matrix[i][j]-'0';
                
                max = Math.max(max, dp[i][j]);
            }
        }    
        
        
        
        // for(int i=0; i<h; i++){
        //     for(int j=0; j<w; j++){
        //         System.out.print(dp[i][j] + ", ");
        //     }
        //     System.out.println();
        // }
        return max*max;
    }
        
}