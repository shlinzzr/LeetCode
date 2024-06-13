// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination

class Solution {
    public int shortestPath(int[][] grid, int K) {
        int h = grid.length;
        int w = grid[0].length;
        
        if(h==1 && w==1)  return 0;
        
        int[][] dirs = new int[][]{{0,1}, {1,0},{0,-1},{-1,0}};
        
        int[][][] dp = new int[41][41][1601];
        // dp[0][0][0]=1;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        
        
        int res = 0;
        
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
                        if(dp[r][c][k+1]==1) continue;
                        dp[r][c][k+1]=1;
                        q.offer(new int[]{r,c,k+1});
                        
                    }else{
                        
                        if(dp[r][c][k]==1) continue;          
                        dp[r][c][k]=1;
                        q.offer(new int[]{r,c,k});
                    }
                }
            }
            step++;
            
        }
        
//          for(int i=0; i<h; i++){
//                 for(int j=0; j<w; j++){
//                     System.out.print(tmp[i][j] + ",");
//                 }
                
//                 System.out.println();
//             }
        
        return -1;
        
        
    }
}