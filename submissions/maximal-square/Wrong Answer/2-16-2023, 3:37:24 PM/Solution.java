// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0 ;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            if(matrix[i][n-1]=='1')
                dp[i][n-1]=1;
        }
        
        for(int j=0; j<n; j++){
            if(matrix[m-1][j]=='1')
                dp[m-1][j]=1;
        }
        
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                
                if(matrix[i][j]=='1'){
                    dp[i][j]=1;
                    
                    if(dp[i+1][j+1]>0 && dp[i+1][j]>0 && dp[i][j+1]>0){
                        dp[i][j] = dp[i+1][j+1]+1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        
        return max*max;
        
    }
}