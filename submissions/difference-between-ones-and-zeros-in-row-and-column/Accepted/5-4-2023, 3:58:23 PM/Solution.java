// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int[] onesRow = new int[h];
        for(int i=0; i<h; i++){
            int ones =0;
            for(int j=0; j<w; j++){
                if(grid[i][j]==1)
                    ones++;
            }
            onesRow[i] = ones;
        }
        
        int[] onesCol = new int[w];
        for(int j=0; j<w; j++){
            int ones = 0;
            for(int i=0; i<h; i++){
                if(grid[i][j]==1)
                    ones++;
            }
            onesCol[j] = ones;
        }
        
        
        
        int[][] diff = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                diff[i][j] = onesRow[i] + onesCol[j] - (h-onesRow[i]) - (w-onesCol[j]);
            }
        }
        
        return diff;
        // onesRowi + onesColj - zerosRowi - zerosColj
        
    }
}