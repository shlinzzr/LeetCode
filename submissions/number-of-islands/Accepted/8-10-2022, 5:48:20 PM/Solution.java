// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        
        int cnt=0;
        int h = grid.length;
        int w = grid[0].length;
        
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                
                if(grid[r][c]=='1'){
                    bfs(grid, new int[]{c, r});
                    cnt++;
                }
            }
        }
        
        return cnt;
        
    }
    
    private void bfs(char[][] grid, int[] p){
        
        Queue<int[]> qq = new LinkedList<>();
        grid[p[1]][p[0]]='2';
        qq.offer(p);
        
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(!qq.isEmpty()){
            
            int[] cell = qq.poll();
            
            // System.out.println("x="+cell[0] + " y=" + cell[1]);
            
            for(int[] d : dirs){
                int px = cell[0] + d[0];
                int py = cell[1] + d[1];

                if(px<0 || px>=grid[0].length || py<0 || py>=grid.length || grid[py][px]!='1')
                    continue;
                
                
                
                
                grid[py][px]='2';
                qq.offer(new int[]{px, py});
            }
        }
    }
            
   
}