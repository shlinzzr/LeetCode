// https://leetcode.com/problems/largest-magic-square

class Solution {
    public int largestMagicSquare(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        int[][] presum_row = new int[h+1][w+1];
        int[][] presum_col = new int[h+1][w+1];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                presum_row[i+1][j+1] = grid[i][j] + presum_row[i+1][j];
            }
        }
        
        for(int j=0; j<w; j++){
            for(int i=0; i<h; i++){
                presum_col[i+1][j+1] = grid[i][j] + presum_col[i][j+1];
            }
        }
        int res= 1 ;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                for(int e=Math.min(i, j); e>res; e--){

                    int target = presum_row[i+1][j+1]-presum_row[i+1-e][j+1];

                    System.out.println(i+" " + j + " " + e+ " " + target);

                    if(isValid(target, presum_row, presum_col, grid, i+1, j+1, e)){
                        res = Math.max(res, e);
                    }
                }
            }
        }

        return res;
    }


    private boolean isValid(int target, int[][] presum_row, int[][] presum_col, int[][] grid, int i, int j, int e){

            // check every row
        for (int k = 0; k < e; k++) {
            if (presum_row[i-k][j] - presum_row[i-k][j-e]!= target) {
                return false;
            }
        }

        // check every column
        for (int k = 0; k < e; k++) {
            if (presum_col[i][j-k] - presum_col[i-e][j-k] != target) {
                return false;
            }   
        }

        // check both diagonal
        int diagonal = 0;
        //  \
        //   \
        for (int k = 0; k < e; k++) {
            diagonal += grid[i - k][j - k];
        }

        if (diagonal != target) {
            return false;
        }

        //   /
        //  /
        for (int k = 0; k < e; k++) {
            diagonal -= grid[i - e + 1 - k][j - k];
        }

        return diagonal == 0;
    }
        
}