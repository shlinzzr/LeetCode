// https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k

class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] dirs = new int[][]{{1,0},{0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,grid[0][0]}); // r, c, sum
        
        int res = 0;
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            
            for(int[] d : dirs){
                int r = d[0]+p[0];
                int c = d[1]+p[1];
              
                
                if(r<0 || c<0 || r>=h || c>=w )
                    continue;
                
                  int v = p[2]+grid[r][c];
                
                
                if(r==h-1 && c==w-1){
                    if(v%k==0)
                        res++;
                    continue;
                }
                
                q.offer(new int[]{r,c, v} );
                
            }
        }
        
        return res;
    }
}