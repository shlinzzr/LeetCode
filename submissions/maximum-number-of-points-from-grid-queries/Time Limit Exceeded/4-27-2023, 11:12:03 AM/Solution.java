// https://leetcode.com/problems/maximum-number-of-points-from-grid-queries

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int[] res = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            
            int n = queries[i];
            
            int cnt =1;
            if(n<=grid[0][0]){
                res[i]=0;
                continue;
            }
            
            
            boolean[][] bool = new boolean[h][w];
            bool[0][0]=true;
            Queue<int[]> q = new LinkedList<>(); 
            q.offer(new int[]{0,0});
            
            
            
            
            
            while(!q.isEmpty()){
                int[] p = q.poll();
                
                for(int[] d: dirs){
                    
                    int r = d[0] + p[0];
                    int c = d[1] + p[1];
                    
                    if(r<0 || c<0 || r>=h || c>=w || bool[r][c] || n<=grid[r][c])
                        continue;
                    
                    q.offer(new int[]{r,c});
                    bool[r][c]=true;
                    cnt++;
                }
                
            }
            
            res[i]=cnt;
            
        }
        return res;
    }
}