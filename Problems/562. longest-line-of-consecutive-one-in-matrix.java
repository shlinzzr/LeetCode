// https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix

class Solution {
    public int longestLine(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;
        
        int[][][] dp = new int[h][w][4];
        
        int max = 0;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0)
                    continue;
                
                //先填自己
                for(int k=0; k<4; k++){
                    dp[i][j][k]=1;
                }
                
                if(i>0) // vertival;
                    dp[i][j][0] += dp[i-1][j][0]; 
                
                if(j>0) // horizontal
                    dp[i][j][1] += dp[i][j-1][1]; 
                
                if(i>0 && j>0) // anti-diagonal
                    dp[i][j][2] += dp[i-1][j-1][2];
                
                if(i>0 && j<w-1) // diagonal
                    dp[i][j][3] += dp[i-1][j+1][3];
                
                
                int max1 = Math.max(dp[i][j][0], dp[i][j][1]);
                int max2 = Math.max(dp[i][j][2], dp[i][j][3]);
                int max3 = Math.max(max1, max2);
                max = Math.max(max, max3);
                
            }
        }
        
        return max;
        
    }
}