// https://leetcode.com/problems/check-knight-tour-configuration

class Solution {
    
    int[][] dirs = new int[][]{{1,2}, {2,1}, {-1,2}, {-2,1} ,{1, -2}, {2, -1}, {-1,-2}, {-2, -1}};
    
    public boolean checkValidGrid(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        return  helper(0, 0, h, 0, grid);
        
        
        
        
        
        
    }
    
    
    private boolean helper(int r, int c, int n, int val, int[][] grid){
        if(r<0 || r>=n || c<0 || c>=n || val!=grid[r][c])
            return false;
        
        if(val==n*n-1)
            return true;
        
        for(int i=0; i<8; i++){
            
            boolean bool = helper(r+dirs[i][0], c+dirs[i][1], n, val+1, grid);
            if(bool)
                return true;
            
        }
        
        return false;
        
        
    }
}