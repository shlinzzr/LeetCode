// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid

class Solution {
    public int findMaxFish(int[][] grid) {
        int res = 0;
        int h = grid.length;
        int w = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] seen = new boolean[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]!=0 && seen[i][j]==false){
                    seen[i][j]=true;
                    int val =  bfs(grid, i, j, seen, grid[i][j] );
                    res = Math.max(res, val);
                }
            }
        }
        return res;
    }
    
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    private int bfs(int[][] grid, int i, int j, boolean[][] seen, int cur){
        
        int h = grid.length;
        int w = grid[0].length;
        
        int res= cur;
        
        for(int[] d : dirs){
            
            int r = d[0]+i;
            int c = d[1]+j;
            
            if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || grid[r][c]==0)
                continue;
            seen[r][c]=true;
            res += bfs(grid, r, c, seen, grid[r][c]);
            
        }
        
        return res;
        
    }
}