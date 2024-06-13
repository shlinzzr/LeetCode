// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination

class Solution {
    public int shortestPath(int[][] grid, int K) {
        int h = grid.length;
        int w = grid[0].length;
        
        if(h==1 && w==1)  return 0;
        
        int[][] dirs = new int[][]{{0,1}, {1,0},{0,-1},{-1,0}};
        
        boolean[][][] seen = new boolean[41][41][1601]; // 1 <= m, n <= 40,,  1 <= k <= m * n
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        
        int step = 0;
        while(!q.isEmpty()){
            
            int siz = q.size();
            while(siz-->0){
                
                int[] p = q.poll();
                
                for(int[] d : dirs){
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    int k = p[2];

                    if(r<0|| c<0 || r>=h || c>=w)
                        continue;
                    
                    if(r==h-1 && c==w-1) return step+1;
                    
                    if(grid[r][c]==1){
                        
                        if(k==K) continue;
                        if(seen[r][c][k+1]==true) continue;
                        seen[r][c][k+1]=true;
                        q.offer(new int[]{r,c,k+1});
                        
                    }else{
                        
                        if(seen[r][c][k]==true) continue;          
                        seen[r][c][k]=true;
                        q.offer(new int[]{r,c,k});
                    }
                }
            }
            step++;
        }
        
        return -1;
        
        
    }
}