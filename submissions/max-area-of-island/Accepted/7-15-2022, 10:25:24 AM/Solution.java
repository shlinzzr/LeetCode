// https://leetcode.com/problems/max-area-of-island

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int height = grid.length;
        int width = height>0 ? grid[0].length : 0;
        int max = 0;
        
        
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                
                if(grid[y][x]==1){
                    int[] pos = new int[]{y, x};
                    max = Math.max(max, bfs(pos, grid));
                }
                    
                
            }
        }
        
        return max;
        
        
    }
    
    private int bfs(int[] pos, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(pos);
        
       
        int max=0;
        
        while(!queue.isEmpty()){
            
            pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            System.out.println(x +","+ y);
            
            if(grid[y][x]==1){
                max++;
                grid[y][x] = 2;
                
                if(y-1>=0 && grid[y-1][x]==1) queue.offer(new int[]{y-1, x});
                if(x-1>=0 && grid[y][x-1]==1) queue.offer(new int[]{y, x-1});
                if(y+1<grid.length && grid[y+1][x]==1) queue.offer(new int[]{y+1, x});
                if(x+1<grid[0].length  && grid[y][x+1]==1) queue.offer(new int[]{y, x+1});
            }
        }
        
        return max;
        
        
        
    }
}