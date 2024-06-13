// https://leetcode.com/problems/number-of-closed-islands

class Solution {
    public int closedIsland(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][] seen = new boolean[h][w];
        
        int cnt=0;
        Queue<int[]> q= new LinkedList<>();
        for(int i=1; i<h-1; i++){
            for(int j=1; j<w-1; j++){
                
                if(grid[i][j]==0 && seen[i][j]==false){
                    seen[i][j] = true;
                    boolean valid = bfs(grid, j, i, seen);
                    System.out.println(i + " " + j + " " + valid + " " + grid[i][j]);
                    if(valid)
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
            
            int r = y+d[0];
            int c = x+d[1];
            
            System.out.println(y + " " + x + " " + r + " " + c + " "); 
            
            if(c<0 || c>=w || r<0 || r>=h || seen[r][c] || grid[r][c]==1)
                continue;
             System.out.println("grid["+r + "][" + c + "]= " + grid[r][c]);          
           
            if(grid[r][c]==0){
                seen[r][c] = true;
                res = res && bfs(grid, c, r, seen);
            }
        }
        
        
        return res;
        
    }
    
    /*[[0,0,1,0,0],
       [0,1,0,1,0],
       [0,1,1,1,0]]*/
}