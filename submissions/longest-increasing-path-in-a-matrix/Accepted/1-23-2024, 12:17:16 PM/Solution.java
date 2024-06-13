// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        int[][] memo = new int[h][w];
        for(int[] m : memo){
            Arrays.fill(m, 1);
        }
        int max = 1;
        for(int i=0;i<h;i++){
            for(int j=0; j<w; j++){
                if(memo[i][j]==1){
                    int rt = dfs(matrix, i, j,  memo);
                    max = Math.max(max, rt);
                }
            }
        }

        return max;
        
    }

    private int dfs(int[][] matrix, int i, int j, int[][]memo){
         int h = matrix.length;
        int w = matrix[0].length;

        if(memo[i][j]>1){
            return memo[i][j];
        }

        int max = 1 ;
        for(int[] d : dirs){
            int r = d[0]+i;
            int c = d[1]+j;

            if(r>=0 && c>=0 && r<h && c<w && matrix[i][j]<matrix[r][c]){
                int rt = 1 + dfs(matrix, r, c, memo);
                max = Math.max(max, rt);
            }
        }

        memo[i][j] = max;
        return max;
    }
}