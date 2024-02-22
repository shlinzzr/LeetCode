// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid

class Solution {
    public int maxMoves(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
       
        
        // (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1)
        int[][] dirs = new int[][]{{-1,+1},{0,1},{1,1}};
        
        
        int max = 0;
        
        boolean[][] seen = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        
        
        for(int i=0; i<h; i++){
              q.offer(new int[]{i,0});
              seen[i][0]=true;
        }
       
          
        int step=0;
        while(!q.isEmpty()){
                
            max = Math.max(max, step);
                
            int siz = q.size();
            for(int j=0; j<siz; j++){
                int[] p = q.poll();
                    
                int cur = grid[p[0]][p[1]];
                    
                for(int[] d : dirs){
                        
                    int r = d[0]+p[0];
                    int c = d[1]+p[1];
                        
                    if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || grid[r][c]<=cur)
                     continue;
                    seen[r][c]=true;
                        
                    q.offer(new int[]{r,c});
                        
                }
            }
            step++;
        }
        
        return max;
        
        
        
    }
}