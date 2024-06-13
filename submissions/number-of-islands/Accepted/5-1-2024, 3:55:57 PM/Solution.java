// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int cnt= 0 ;
        boolean[][] seen = new boolean[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]=='1' && seen[i][j]==false){
                    dfs(grid, i, j, seen);
                    cnt++;
                }
                
            }
        }
        
        return cnt;
        
    }
    
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(char[][] grid, int i, int j, boolean[][]seen){
        
        int h = grid.length;
        int w = grid[0].length; 
        
        seen[i][j] = true;
        
        for(int[] d : dirs){
            int r = i+d[0];
            int c = j+d[1];
            
            if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || grid[r][c]=='0') continue;
            dfs(grid, r, c , seen);
        }
        
        
        
    }
}