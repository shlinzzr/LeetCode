// https://leetcode.com/problems/minimum-falling-path-sum

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        
        int[] dp = new int[w];
        for(int i=0; i<h; i++){
            
            
            int[] temp = new int[w];
            
            for(int j=0; j<w; j++){
                
                if(i==0){
                    temp[j] = matrix[i][j];
                    
                    // System.out.println(dp[j]);
                    continue;
                }
                
                
                int val = ((j==0)? Math.min(dp[j], dp[j+1]) : (j==w-1) ? Math.min(dp[j-1], dp[j]) :Math.min(dp[j-1], Math.min(dp[j], dp[j+1])));
                val +=  matrix[i][j] ;
                temp[j]=val;
                
            }
            dp = temp;
            
            
        }
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i<w; i++){
            // System.out.println(dp[i]);
            res = Math.min(res, dp[i]);
        }
        
        return res;
        
        
    }
}