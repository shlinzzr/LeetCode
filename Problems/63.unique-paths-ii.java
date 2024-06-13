// https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {

        int h = ob.length;
        int w = ob[0].length;

        int[][] dp = new int[h+1][w+1];
        if(ob[0][0]==1 || ob[h-1][w-1]==1) return 0;

        dp[1][1] = 1;

        for(int i=2; i<=h; i++){
            if(ob[i-1][0]==0)
                dp[i][1] = dp[i-1][1];
        }

        for(int j=2; j<=w; j++){
            if(ob[0][j-1]==0){
                dp[1][j] = dp[1][j-1];
            }
        }

        for(int i=2; i<=h; i++){
            for(int j=2; j<=w; j++){

                if(ob[i-1][j-1]==0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[h][w];




        
    }
}