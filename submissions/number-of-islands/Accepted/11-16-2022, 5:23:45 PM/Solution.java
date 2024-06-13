// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        
        int cnt=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]=='1'){
                    dfs(grid, new int[]{i,j});
                    cnt++;
                }
                
            }
        }
        
        return cnt;
    }
    
    int[][] dirs = new int[][]{{0,1},{1,0}, {0,-1}, {-1,0}};
    private void dfs(char[][] grid, int[] p){
        
         int h = grid.length;
        int w = grid[0].length;
        
        for(int[] d : dirs){
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            if(r<0 || c<0 || r>=h || c>=w || grid[r][c]!='1')
                continue;
            
            grid[r][c] ='0';
            dfs(grid, new int[]{r,c});
        }
        
    }
}
