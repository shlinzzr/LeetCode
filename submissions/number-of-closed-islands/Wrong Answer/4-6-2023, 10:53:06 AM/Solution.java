// https://leetcode.com/problems/number-of-closed-islands

class Solution {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int closedIsland(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][] seen = new boolean[h][w];
        
        int cnt=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==0 && seen[i][j]==false){
                    seen[i][j] = true;
                    boolean valid = bfs(grid, i, j, seen);
                    if(valid)
                        cnt++;
                }
            }
        }
        
        return cnt;
    }
    
 
    
    private boolean bfs(int[][] grid, int y, int x, boolean[][] seen){
        
        int h = grid.length;
        int w = grid[0].length;
        
        if(x<=0 || x>=w-1 || y<=0 || y>=h-1)
            return false;
        
        boolean res = true;
        
        for(int[] d: dirs){
            
            int r = y+d[0];
            int c = x+d[1];
            
            if(c<0 || c>=w || r<0 || r>=h || seen[r][c] || grid[r][c]==1)
                continue;
            
            
            
            seen[r][c] = true;
                
            boolean valid = bfs(grid, r, c, seen);
            
            // System.out.println("grid[" + r + "]["+ c+ "]=" + valid);
            res =  res || valid;
        }
        
        
        return res;
        
    }
}
    
  /*
  [[1,1,1,1,1,1,1,0]
  ,[1,0,0,0,0,1,1,0]
  ,[1,0,1,0,1,1,1,0]
  ,[1,0,0,0,0,1,0,1]
  ,[1,1,1,1,1,1,1,0]]
  
  
  
  [[1,0,1,1,1,1,0,0,1,0]
    ,[1,0,1,1,0,0,0,1,1,1]
    ,[0,1,1,0,0,0,1,0,0,0]
    ,[1,0,1,1,0,1,0,0,1,0]
    ,[0,1,1,1,0,1,0,1,0,0]
    ,[1,0,0,1,0,0,1,0,0,0]
    ,[1,0,1,1,1,0,0,1,1,0]
    ,[1,1,0,1,1,0,1,0,1,1]
    ,[0,0,1,1,1,0,1,0,1,1]
    ,[1,0,0,1,1,1,1,0,1,1]]
    

*/
