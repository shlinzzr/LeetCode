// https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {

        int h = ob.length;
        int w = ob[0].length;

        int[][] dp = new int[h][w];

        for(int i=0; i<h; i++){
            if(ob[i][0]==1) break;
            dp[i][0] = 1;
        }
        
        for(int j=0; j<w; j++){
            if(ob[0][j]==1) break;
            dp[0][j] = 1;
        }

        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                
                if(ob[i][j]==1) continue;

                dp[i][j] = dp[i-1][j] + dp[i][j-1];


            }
        }
        return dp[h-1][w-1];
    }
}