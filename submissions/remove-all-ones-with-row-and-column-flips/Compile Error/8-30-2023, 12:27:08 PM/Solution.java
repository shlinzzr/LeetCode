// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips

class Solution {
    public boolean removeOnes(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        //Scan the first row to zero and flip if required
        for(int c=0;c<w;c++){
            if(grid[0][c]==1){
                //flip the this whole column
                for(int r=0;r<h;r++){
                    grid[r][c] = grid[r][c]==1?0:1;
                }
            }
        }
        
        
        /* 
        0 1 0
        1 0 1
        0 1 0
        
        => 
        
        0 0 0
        1 1 1
        0 0 0
        
        => check row by row
        */
        
        
        
        // we are done with the first row
        // now we can't filp columns again; that would mess up our first row
        // we can only filp rows now onwards; 
        // that means now following rows should have the same value in the whole row
        for(int r=1;r<rows;r++){
            for(int c=1;c<cols;c++){
                if(grid[r][c]!=grid[r][c-1]){
                    return false;
                }
            }
        }
        return true;
        
    }
}