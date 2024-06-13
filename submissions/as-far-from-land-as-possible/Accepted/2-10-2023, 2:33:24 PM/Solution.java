// https://leetcode.com/problems/as-far-from-land-as-possible

class Solution {
    public int maxDistance(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][] seen = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        boolean seenZero=false;
        boolean seenOne=false;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1){
                    q.offer(new int[]{i, j});
                    seen[i][j]=true;
                    seenOne=true;
                }
                
                if(grid[i][j]==0){
                    seenZero=true;
                }
                    
            }
        }
        
        
        if(seenZero==false || seenOne==false)
            return -1;
        
        
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
        int step=0;        
        while(!q.isEmpty()){
            int siz = q.size();
            // System.out.println(siz);
            for(int i=0; i<siz; i++){
                
                int[] p = q.poll();
                
                // System.out.println(p[0]+" "+ p[1]);
                for(int[] d: dirs){
                    
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    
                    if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false && grid[r][c]==0){
                        q.offer(new int[]{r,c});
                        seen[r][c]=true;
                    }
                }
            }
            step++;
        }
        
        return step-1;
       
        
        
        
    }
}