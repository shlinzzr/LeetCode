// https://leetcode.com/problems/max-area-of-island

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // int [][] visited = new int[grid.length()][grid[0].length()];
        
        int max = 0;
        for(int y=0; y<grid.length;y++){
            for(int x=0; x<grid[0].length; x++){
                
                if(grid[y][x]==1){
                    
                    int area = fill(x, y, grid, 0);
                    if(area>max)
                        max = area;
                }
                    
                
            }
        }
        
        
        return max;
    }
    
    private int fill(int x, int y, int[][] grid, int area){
        
        if(x<0 || x>=grid[0].length || y<0 || y>=grid.length || grid[y][x] != 1)
            return area;
        
        grid[y][x] = 2;
        area++;
        
        int right = fill(x+1, y, grid, 0);
        int left =fill(x-1, y, grid, 0);
        int up =fill(x, y+1, grid, 0);
        int down =fill(x, y-1, grid, 0);
        
        return area + right + left + up + down;
        
    }
}