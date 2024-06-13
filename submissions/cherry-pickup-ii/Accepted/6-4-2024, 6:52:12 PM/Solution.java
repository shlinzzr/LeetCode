// https://leetcode.com/problems/cherry-pickup-ii

class Solution {
    public int cherryPickup(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        int[][][] dp = new int[h+1][w+2][w+2]; // i, x1, x2
        
        for(int i=0; i<=h; i++){
            for(int j=0; j<=w+1; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE/2);
            }
        }
        
        dp[0][1][w] = grid[0][0] + grid[0][w-1];
        System.out.println(0 + " " + dp[0][1][w]);
        int max = Integer.MIN_VALUE;
        
        for(int i=1; i<h; i++){
            for(int x1=1; x1<=w; x1++){
                for(int x2=1; x2<=w; x2++){
                    
                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1-1][x2-1]);
                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1-1][x2]);
                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1-1][x2+1]);

                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1][x2-1]);
                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1][x2]);
                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1][x2+1]);

                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1+1][x2-1]);
                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1+1][x2]);
                    dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i-1][x1+1][x2+1]);
                    
                    if(x1==x2) 
                        dp[i][x1][x2]+= grid[i][x1-1];
                    else 
                        dp[i][x1][x2] += grid[i][x1-1] + grid[i][x2-1];
                    
                    max = Math.max(max, dp[i][x1][x2]);
                }
            }
            // System.out.println(i + " " + max);
        }
        
        
        return max;
        
        
            
        
        
        
        
    }
}