// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        int cnt=0;
        
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

        int h = grid.length;
        int w = grid[0].length;
        
        if(i<0 || i>=h || j<0 || j>=w || grid[i][j]!='1')
            return;
        
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        grid[i][j] = '2';
        
        for(int[] d : dirs){
            dfs(grid, i+d[0], j+d[1]);
        }
        
        
    }
}