// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        int h= grid.length;
        int w = grid[0].length;
        
        int cnt =0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    cnt++;
                }
                    
                
            }
        }
        
        return cnt;
    }
    
    
    private void dfs(char[][] grid, int i, int j){
        
        int h= grid.length;
        int w = grid[0].length;
        
        if(i<0 || i>=h || j<0 || j>=w)
            return;
        
        if(grid[i][j]=='0')
          return;
        
        grid[i][j]='0';
        
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        
    }
}