// https://leetcode.com/problems/minimum-falling-path-sum-ii

class Solution {
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;

        int[][] dp = new int[n][n]; // let dp be the minSum of the first i row with j col

        for(int j=0; j<n; j++){
            Arrays.fill(dp[j], Integer.MAX_VALUE);
            dp[0][j] = grid[0][j];
        }


        for(int i=1; i<n; i++){

            for(int j=0; j<n; j++){

                // dp[i][j] = dp[i-1][j];

                for(int k=0; k<n; k++){

                    if(k==j) continue;

                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + grid[i][j]);
                }
            }
        }

        int min = dp[n-1][0];
        for(int j=0; j<n; j++){
            min = Math.min(min, dp[n-1][j]);
        }


        return min;


        // for(int i=0; i<n; i++){

        //     int min = grid[i][0];
        //     for(int j=1; j<n; j++){
        //         min = Math.min(min, grid[i][j]);
        //     }

        //     sum += min;

        // }



        
    }
}