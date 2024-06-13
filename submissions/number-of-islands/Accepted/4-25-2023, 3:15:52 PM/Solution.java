// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        boolean[][] seen = new boolean[h][w];
        int cnt=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]=='1' && seen[i][j]==false){
                    seen[i][j]=true;
                    bfs(grid, seen, i , j);
                    cnt++;
                }
                    
            }
        }
        
        return cnt;
    }
    
    
    int[][]dirs = new int[][]{{0,1},{0,-1}, {1,0}, {-1,0}};    
    
    private void bfs(char[][] grid, boolean[][] seen, int i, int j){
        int h = grid.length;
        int w = grid[0].length;
        
        for(int[] d : dirs){
            int r = i + d[0];
            int c = j + d[1];

            if(r<0 || c<0 || r>=h || c>=w || seen[r][c]==true || grid[r][c]=='0')
                continue;

            seen[r][c] =true;
            bfs(grid, seen, r, c);
        }
            
            
    }
}