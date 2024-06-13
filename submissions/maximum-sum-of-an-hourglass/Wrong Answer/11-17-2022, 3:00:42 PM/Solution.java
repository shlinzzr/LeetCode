// https://leetcode.com/problems/maximum-sum-of-an-hourglass

class Solution {
    public int maxSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] dp = new int[h][w];
        dp[0][0] = grid[0][0];
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                
                if(i==0 && j>0)
                    dp[0][j] = dp[0][j-1] + grid[i][j]; 
                
                else if(j==0 && i>0)
                    dp[i][0] = dp[i-1][0] + grid[i][j];
                
                else if(i>0 && j>0)
                    dp[i][j]= dp[i-1][j] + dp[i][j-1] + grid[i][j];
            }
        }
        
        for(int [] d : dp){
            for(int dd : d){
                System.out.print(dd + ",");
            }
            System.out.println();
        }
        
        
        int max = Integer.MIN_VALUE;
        
        for(int i=2; i<h; i++){
            for(int j=2; j<w; j++){
                
                int sqSum = dp[i][j] + dp[i-1][j-1] - dp[i-1][j] - dp[i][j-1];
                int glassSum = sqSum -grid[i-1][j] - grid[i-1][j-2];
                
                System.out.println(i + "," + j + " glassSum=" + glassSum + " sqSum="+sqSum);
                
                max = Math.max(max, glassSum);
                
                
                
            }
        }
        
        return max;
        
        
    }
}