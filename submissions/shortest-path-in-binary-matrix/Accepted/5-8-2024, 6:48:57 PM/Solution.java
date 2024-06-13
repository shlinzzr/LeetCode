// https://leetcode.com/problems/shortest-path-in-binary-matrix

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        
        if(n==1)
            return 1;
        
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] bool = new boolean[n][n];
        bool[0][0]=true;
        q.offer(new int[]{0,0});
        
        int[][] dirs = new int[][]{{0,1},{1,0}, {-1, 0}, {0, -1}, {1,1}, {-1,-1},{1,-1},{-1,1}};
        
        int step=1;
        
        while(!q.isEmpty()){
            
            for(int i =q.size(); i>0; i--){
                
                int[] p = q.poll();
                
                for(int[] d : dirs){
                    int r = d[0]+p[0];
                    int c = d[1]+p[1];
                    
                    if(r<0 || c<0 || r>=n || c>=n || bool[r][c] || grid[r][c]==1)
                        continue;
                    
                    if(r==n-1 && c==n-1)
                        return step+1;
                    
                    
                    bool[r][c]=true;
                    q.offer(new int[]{r,c});
                    
                }
            }
            step++;
        }
        
        return -1;
    
    }
}