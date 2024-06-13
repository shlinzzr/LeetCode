// https://leetcode.com/problems/shortest-path-in-binary-matrix

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int h = grid.length;
        int w = grid.length;
        
        Queue<int[]> q = new LinkedList<>();
        
        if(grid[0][0]==1 || grid[h-1][w-1]==1)
            return -1;
        
        if(h==1)
            return 1;
        
        q.offer(new int[]{0,0});
        boolean[][] seen = new boolean[h][w];
        seen[0][0]=true;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1, 0}, {0, -1}, {1,1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        int step=1;
        
        while(!q.isEmpty()){
            
            int siz = q.size();
            for(int i=0; i<siz; i++){
                
                int[] p = q.poll();
                
                for(int[] d : dirs){
                    
                    int r = d[0] + p[0];
                    int c = d[1] + p[1];
                    
                   
                    
                    if(r<0 || c<0 || r>=h || c>=w || seen[r][c]==true || grid[r][c]==1)
                        continue;
                    
                    System.out.println(r + " " + c);
                    
                     if(r==h-1 && c==w-1)
                        return step+1;
                    
                    seen[r][c]=true;
                    
                    
                    q.offer(new int[]{r,c});
                    
                }
            }
            
            step++;
            
            
        }
        
        return -1;
        // 
        // [[1,0,0]
        // ,[1,1,0]
        // ,[1,1,0]]
    }
}