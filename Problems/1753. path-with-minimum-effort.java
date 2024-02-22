// https://leetcode.com/problems/path-with-minimum-effort

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int h = heights.length;
        int w = heights[0].length;
        
        if(h==1 && w==1)
            return 0;
        
        
        int st=0, ed=Integer.MAX_VALUE;
        
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            
            if(isOk(heights, mid)){
                ed = mid;
            }else{
                st= mid+1;
            }
        }
        
        return st;
        
        
    }
    
    
    private boolean isOk(int[][] grid, int effort){
        
        
          
        // System.out.println("isOk " + effort + " ");
            
        
        
        int h = grid.length;
        int w = grid[0].length;
        
     
        
        boolean[][] bool = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        q.offer(new int[]{0,0});
        bool[0][0]=true;
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            // System.out.println(p[0] + " " + p[1] );
            
            for(int[] d: dirs){
                
                int r = d[0]+p[0];
                int c = d[1]+p[1];
        
                if(r<0 || c<0 || r>=h || c>=w || bool[r][c] || Math.abs(grid[r][c]-grid[p[0]][p[1]])>effort)
                    continue;
                
                
                if(r==h-1 && c==w-1)
                    return true;
                
                bool[r][c] = true;
                q.offer(new int[]{r,c});
            }            
        }
          
         // System.out.println("isOk " + effort + " false");
            
        return false;        
        
    }
}