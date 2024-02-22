// https://leetcode.com/problems/minimum-falling-path-sum

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int h= matrix.length;
        int w = matrix[0].length;

        int[][] dp = new int[h+1][w];
        for(int i=1; i<=h; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=h; i++){
            for(int j=0; j<w; j++){

                dp[i][j] = dp[i-1][j] + matrix[i-1][j];

                if(j-1>=0)
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+matrix[i-1][j]);
                if(j+1<w)
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]+matrix[i-1][j]);

                if(i==h){
                    min = Math.min(min, dp[i][j]);
                }

            }
        }

        
        return min;



    }
}