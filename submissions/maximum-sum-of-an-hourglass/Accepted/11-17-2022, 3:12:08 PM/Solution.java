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
                    dp[i][j]= dp[i-1][j] + dp[i][j-1] + grid[i][j] - dp[i-1][j-1];
            }
        }
        
//         for(int [] d : dp){
//             for(int dd : d){
//                 System.out.print(dd + ",");
//             }
//             System.out.println();
//         }
//         /*
// 6,8,9,12,
// 10,20,30,47,
// 19,41,79,133,
// 23,65,146,288,
// 2,2 glassSum=23 sqSum=28
// 2,3 glassSum=30 sqSum=37
// 3,2 glassSum=26 sqSum=43
// 3,3 glassSum=79 sqSum=88
// */
        
        
        int max = Integer.MIN_VALUE;
        
        for(int i=2; i<h; i++){
            for(int j=2; j<w; j++){
                
                int sqSum = dp[i][j] ;
                
                if(i-3>=0) sqSum -= dp[i-3][j];
                if(j-3>=0) sqSum -= dp[i][j-3];
                if(i-3>=0 && j-3>=0) sqSum +=dp[i-3][j-3];
                
                int glassSum = sqSum-grid[i-1][j] - grid[i-1][j-2];
                
                // System.out.println(i + "," + j + " glassSum=" + glassSum + " sqSum="+sqSum);
                
                max = Math.max(max, glassSum);
                
                
            }
        }
        
        return max;
        
        
    }
}