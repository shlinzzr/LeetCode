// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];

        int max = 0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1]=='1'){
                    max = Math.max(max, 1);
                    if(i==1 && j==1){
                        dp[i][j] = 1;

                    }else if(i==1){
                        dp[i][j] = dp[i][j-1] + 1;

                    }else if(j==1){
                        dp[i][j] = dp[i-1][j] +1;

                    }else{
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                        max = Math.max(max, dp[i][j]);
                    }

                  
                }
            }
        }

        //   for(int i=1; i<=m; i++){
        //     for(int j=1; j<=n; j++){
        //         System.out.print(dp[i][j] + ",");
        //     }
        //     System.out.println();
        //   }





        // dp[1][1] = matrix[0][0]-'0';

        // for(int i=2; i<=m; i++){
        //     if(matrix[i-1][0]=='1')
        //         dp[i][1] = 1 + dp[i-1][1];
        // }

        // for(int j=2; j<=n; j++){
        //     if(matrix[0][j-1]=='1'){
        //         dp[1][j] = 1 + dp[1][j-1];
        //     }
        // }

        // int max= 0;

        // for(int i=1; i<=m; i++){
        //     for(int j=1; j<=n; j++){
                
        //         if(matrix[i-1][j-1]=='1')
        //             dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;

        //         max = Math.max(max, dp[i][j]);
        //     }
        // }

        return max*max;
    }
}