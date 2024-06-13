// https://leetcode.com/problems/cherry-pickup

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        if(grid[0][0]==-1 || grid[n-1][n-1]==-1)
            return -1;  

        int[][] dp = new int[n][n];
        // for(int[] d : dp){
        //     Arrays.flill(d, -1);
        // }
        dp[0][0] = grid[0][0];

        for(int i=1; i<n; i++){

            dp[i][0] = dp[i-1][0]==-1 || grid[i][0]==-1 ? -1 : dp[i-1][0] + grid[i][0];
            dp[0][i] = dp[0][i-1]==-1 || grid[0][i]==-1 ? -1 : dp[0][i-1]  + grid[0][i];
        }

          for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
          }

 System.out.println();

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){

                int up = dp[i-1][j]==-1? 0 : dp[i-1][j];
                int left = dp[i][j-1]==-1? 0 : dp[i][j-1];

                dp[i][j] = ((dp[i-1][j]==-1 && dp[i][j-1]==-1) || grid[i][j]==-1 )? -1 : Math.max(up , left) + grid[i][j];

                
                System.out.println("i="+i + " j="+j + " dp="+dp[i][j] + ",");
                System.out.println("dp[i-1][j]="+dp[i-1][j] + " dp[i][j-1]="+dp[i][j-1] + " grid[i][j]="+grid[i][j] + ",");
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
          }


        return dp[n-1][n-1];
    }
}