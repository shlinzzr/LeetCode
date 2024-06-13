// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0; 
        
        int h = grid.length;
        int w = grid[0].length;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]=='1'){
                    dfs(grid, new int[]{i, j});
                    res++;
                }
                
            }
            
        }
        
        return res;
            
        
    }
    
    private void dfs(char[][] grid, int[] p){
        
        int h = grid.length;
        int w = grid[0].length;
        
        int x = p[1];
        int y = p[0];
        
        if(x<0 || x>=w || y<0 || y>=h || grid[y][x]!='1')
            return;
        
        grid[y][x]='2';
        dfs(grid, new int[]{y+1, x});
        dfs(grid, new int[]{y-1, x});
        dfs(grid, new int[]{y, x+1});
        dfs(grid, new int[]{y, x-1});
        
        
        
    }
    
    
}