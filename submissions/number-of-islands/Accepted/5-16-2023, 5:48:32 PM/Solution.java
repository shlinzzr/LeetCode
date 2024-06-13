// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][] seen = new boolean[h][w];
        
        int cnt = 0;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]=='1' && seen[i][j]==false){
                    cnt++;
                    bfs(grid, i, j, seen);
                }
            }
        }
        
        return cnt;
        
        
    }
    
    
    private void bfs(char[][] grid, int i, int j, boolean[][] seen){
        int h = grid.length;
        int w = grid[0].length;
        
        if(i<0 || j<0 || i>=h || j>=w || seen[i][j] || grid[i][j]=='0')
            return;
        
        seen[i][j]=true;
        
        bfs(grid, i+1, j, seen);
        bfs(grid, i-1, j, seen);
        bfs(grid, i, j+1, seen);
        bfs(grid, i, j-1, seen);
        
    }
}