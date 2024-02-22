// https://leetcode.com/problems/the-maze

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int h = maze.length;
        int w = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        
        boolean[][] seen = new boolean[h][w];
        seen[start[0]][start[1]]=true;
        
        
        int[][] dirs = new int[][]{{0,1},{1,0}, {0,-1}, {-1,0}};
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            
            for(int di=0; di<4; di++){
                
                int[] d = dirs[di];
                
                int r = d[0] + p[0];
                int c = d[1] + p[1];
                
                if(r<0 || c<0 || r>=h || c>=w || maze[r][c]==1){
                    continue;
                }
                
                while(r+d[0]>=0 && c+d[1]>=0 && r+d[0]<h && c+d[1]<w && maze[r+d[0]][c+d[1]]==0){
                    r += d[0];
                    c += d[1];
                }
                
                if(seen[r][c]==true)
                    continue;
                
                if(r==destination[0] && c==destination[1])
                    return true;
                
                seen[r][c] = true;
                q.offer(new int[]{r,c});
            }
            
        }
        
        return false;
        
        
    }
}