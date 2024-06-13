// https://leetcode.com/problems/max-area-of-island

class Solution {
    
    int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int max=0;
        
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1){
                    max = Math.max(max , dfs(grid, new int[]{i, j}, h, w));
                    // System.out.println( "max="+max);    
                }
                
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] grid, int[] p, int h, int w){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(p);
        // boolean[][] visited = new boolean[h][w];
        grid[p[0]][p[1]]=2;
        int area = 0;
        
        while(!q.isEmpty()){
            p = q.poll();
            
            // System.out.println( p[0] + "," + p[1]);
            
            area++;
            for(int[] d : dirs){
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                if(r>=0 && r<h && c>=0 && c<w && grid[r][c]==1 ){
                    grid[r][c]=2;
                    q.offer(new int[]{r,c});
                } 
            }
        }
        
        return area;
    }
    
}