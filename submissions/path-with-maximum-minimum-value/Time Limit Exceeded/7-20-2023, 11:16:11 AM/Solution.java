// https://leetcode.com/problems/path-with-maximum-minimum-value

class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        
        int st=0, ed=grid[0][0];
        
        while(st<ed){
            
            int mid = st + (ed-st+1)/2;
            
            if(isOk(grid, mid)){
                st = mid;
            }else{
                ed= mid-1;
            }
        }
        
        return st;
        
        
    }
    
    
    private boolean isOk(int[][] grid, int m){
        
         System.out.println("isOk " + m);
            
        System.out.println(  Integer.MAX_VALUE);
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][] bool = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        q.offer(new int[]{0,0});
        bool[0][0]=true;
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            
            
            System.out.println(p[0] + " " + p[1] );
            
            for(int[] d: dirs){
                
                int r = d[0]+p[0];
                int c = d[1]+p[1];
        
                if(r<0 || c<0 || r>=h || c>=w || bool[r][c] || grid[r][c]<m)
                    continue;
                
                
                if(r==h-1 && c==w-1)
                    return true;
                
                bool[r][c] = true;
                q.offer(new int[]{r,c});
            }            
        }
          
         System.out.println("isOk " + m + " false");
            
        return false;        
        
        /*
        [[0,1,0,0,0,1],
         [0,1,1,0,0,0],
         [0,0,1,1,0,1],
         [0,1,1,1,1,0],
         [1,1,1,1,1,1]]*/
        
        
    }
}