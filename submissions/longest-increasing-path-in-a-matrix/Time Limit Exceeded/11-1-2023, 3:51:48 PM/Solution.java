// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        int[][] dp = new int[h][w];
        for(int[] d: dp){
            Arrays.fill(d, 1);
        }

        // Queue<int[]> q = new LinkedList<>();
        int max = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(dp[i][j]==1){
                    int res = dfs(matrix, i, j, dp);
                    max = Math.max(max, res);
                }
            }
        }
        return max;
    }
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int dfs(int[][] matrix, int i, int j, int[][] dp){

        int h = matrix.length;
        int w = matrix[0].length;

        // if(dp[i][j]!=0)
        //     return dp[i][j];

        int max = 1;
        for(int[] d : dirs){
            int r = i+d[0];
            int c = j+d[1];

            if(r>=0 && c>=0 && r<h && c<w && matrix[r][c]>matrix[i][j]){
                int rt = 1 + dfs(matrix, r, c, dp);
                max = Math.max(max, rt);
            }
        }
        dp[i][j] = max;

        return max;
    }
}