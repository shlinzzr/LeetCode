// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        /*
         grid = [[2,1,1],[1,1,0],[0,1,1]]
         2 : rotted
         */
        
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i, j});
                }
            }   
        }
        
        int[][] dirs = new int[][]{{0,1},{1,0}, {0,-1},{-1,0}};
        int step = 0;        
        while(!q.isEmpty()){
            int size = q.size();
            
                
            while(size-->0) {
                int[] p = q.poll();
                
                for(int[] d: dirs){
                    int r = d[0]+p[0];
                    int c = d[1]+p[1];
                    
                    if(r<0 || c<0 || r>=h || c>=w || grid[r][c]!=1) continue;
                    grid[r][c] = 2;
                    q.offer(new int[]{r,c});
                }
            }
            if(q.size()>0) step++;
        }
       
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
         }
        
        return step;
        
        
        
    }
}