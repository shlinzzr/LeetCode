// https://leetcode.com/problems/number-of-closed-islands

class Solution {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    boolean flag=true;
    
    
    public int closedIsland(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][] seen = new boolean[h][w];
        
         for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1)
                    seen[i][j]= true;
            }
         }
        
        
        
        int cnt=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(i==8)
                    flag=true;
                
                if(grid[i][j]==0 && seen[i][j]==false){
                    seen[i][j] = true;
                    boolean valid = bfs(grid, i, j, seen);
                    // if(flag)
                    //  System.out.println(""+ i + " "+ j + " " + valid);
                    if(valid){
                     
                         cnt++;
                    }
                       
                }
            }
        }
        
        return cnt;
    }
    
 
    
    private boolean bfs(int[][] grid, int y, int x, boolean[][] seen){
        
        // if(flag)
        //     System.out.println("bfs y=" + y +  " x="+x);
        
        int h = grid.length;
        int w = grid[0].length;
        
        boolean res = (y==0 || y==w-1 || x==0 || x==h-1 ) ? false : true;
        
        for(int[] d: dirs){
            
            int r = y+d[0];
            int c = x+d[1];
            
            if(c<0 || c>=w || r<0 || r>=h || seen[r][c] || grid[r][c]==1)
                continue;
            
            
            if(grid[r][c]==0){
                seen[r][c] = true;
                boolean valid = bfs(grid, r, c, seen);
                
                if(c==0 || c==w-1 || r==0 || r==h-1)
                    valid = false;
                
                res =  res && valid;
            }
            
            
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
  
  
  [[0,0,1,1,0,1,0,0,1,0]
  ,[1,1, ,1,1,x,1,1,1,0]
  ,[1, ,1,1,1,x,x,1,1,0]
  ,[0,1,1,x,x,x,x,1, ,1]
  ,[x,x,x,x,x,x,1,1,1,0]
  ,[0,1,x,1,x,1,0,1,1,1]
  ,[1, ,1, ,1,1,0,0,0,1]
  ,[1,1,1,1,1,1,0,0,0,0]
  ,[1,1,1,0,0,1,0,1,0,1]
  ,[1,1,1,0,1,1,0,1,1,0]]
  
  
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
