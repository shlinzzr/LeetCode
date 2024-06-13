// https://leetcode.com/problems/number-of-closed-islands

class Solution {
    public int closedIsland(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][] seen = new boolean[h][w];
        
        int cnt=0;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==0 && seen[i][j]==false){
                    seen[i][j] = true;
                    boolean connectEdge = bfs(grid, i, j, seen);
                    
                    if(connectEdge==false)
                        cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0, -1}};
    
    private boolean bfs(int[][] grid, int x, int y, boolean[][] seen){
        
        int h = grid.length;
        int w = grid[0].length;
        
        if(x==0 || x==w-1 || y==0 || y==h-1)
            return false;
        
        boolean res = true;
        
        for(int[] d: dirs){
            
            int r = x+d[0];
            int c = y+d[1];
            
            if(c<0 || c>=w || r<0 || r>=h || seen[r][c])
                continue;
            
            
            if(grid[r][c]==0){
                seen[r][c] = true;
                res = res && bfs(grid, c, r, seen);
            }
        }
        
        return res;
        
    }
}