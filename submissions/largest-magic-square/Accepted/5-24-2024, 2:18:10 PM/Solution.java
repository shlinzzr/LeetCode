// https://leetcode.com/problems/largest-magic-square

class Solution {
    public int largestMagicSquare(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        
        int[][] presum_row = new int[h][w];
        int[][] presum_col = new int[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                presum_row[i][j] = j==0 ? grid[i][j] : grid[i][j] + presum_row[i][j-1];
            }
        }

        for(int j=0; j<w; j++){
            for(int i=0; i<h; i++){
                presum_col[i][j] = i==0 ? grid[i][j] : grid[i][j] + presum_col[i-1][j];
            }
        }

        int res = 1 ;

        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                int maxEdge = Math.min(h-i, w-j);

                for(int e=maxEdge; e>res; e--){

                    int target = presum_col[i+e-1][j] - presum_col[i][j] + grid[i][j];

                    if(isValid(target, presum_row, presum_col, grid, i, j, e)){
                        res = e;
                        break;
                    }
                        

                }
            }
        }

        return res;

        
    }

    private boolean isValid(int target, int[][] presum_row, int[][] presum_col, int[][] grid, int i, int j, int e){
 
        // check each row
        for(int k=0; k<e; k++){
            if(presum_row[i+k][j+e-1] - presum_row[i+k][j] + grid[i+k][j] != target) return false;
        }

        for(int k=0; k<e; k++){
            if(presum_col[i+e-1][j+k] - presum_col[i][j+k] + grid[i][j+k] != target) return false;
        }

        // check diagonal
        int diagonal = 0 ;
        for(int k=0; k<e; k++){
            diagonal += grid[i+k][j+k];
        }
        if(diagonal!=target) return false;

        for(int k=0; k<e; k++){
            diagonal -= grid[i+e-1-k][j+k];
        }

        if(diagonal!=0) return false;

        return true;




    }
}