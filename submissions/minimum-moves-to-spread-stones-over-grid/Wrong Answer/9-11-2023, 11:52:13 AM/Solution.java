// https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid

class Solution {
    
    int[][] oneStep = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int[][] twoStep = new int[][]{{0,2},{2,0},{0,-2},{-2,0}, {1,1}, {-1,-1},{1,-1},{-1,1}};  
    int[][] threeStep = new int[][]{{1,2},{2,1},{1,-2},{-2,1}};  
    int[][] fourStep = new int[][]{{2,2},{-2,-2},{2,-2},{-2,2}};  
    
    
    public int minimumMoves(int[][] grid) {
        
        int max = 0;
        
        int[] p = new int[2];

        
        int cnt=0;
        
        for(int i=0; i<3; i++){
            for(int j=0;j<3; j++){
                
                if(grid[i][j]>max){
                    max = grid[i][j];
                    p[0]=i;
                    p[1]=j;
                }
                
                if(grid[i][j]!=1)
                    cnt++;
            }
        }
        // System.out.println(p[0]+ " " + p[1]);
        
        if(max==1)
            return 0;
        
        
        // find nearest 0
        for(int[] d : oneStep){
            
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            if(r<0 || c<0 || r>=3 || c>=3 || grid[r][c]!=0)
                continue;
            
            grid[r][c]+=1;
            grid[p[0]][p[1]]-=1;
            
            return 1 + minimumMoves(grid);
        }
        
         for(int[] d : twoStep){
            
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            if(r<0 || c<0 || r>=3 || c>=3 || grid[r][c]!=0)
                continue;
            
            grid[r][c]+=1;
            grid[p[0]][p[1]]-=1;
            
            return 2 + minimumMoves(grid);
        }
        
        for(int[] d : threeStep){
            
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            if(r<0 || c<0 || r>=3 || c>=3 || grid[r][c]!=0)
                continue;
            
            grid[r][c]+=1;
            grid[p[0]][p[1]]-=1;
            
            return 3 + minimumMoves(grid);
        }
           
        for(int[] d : fourStep){
            
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            if(r<0 || c<0 || r>=3 || c>=3 || grid[r][c]!=0)
                continue;
            
            grid[r][c]+=1;
            grid[p[0]][p[1]]-=1;
            
            return 4 + minimumMoves(grid);
        }
        
        return -1;
        
    }
}