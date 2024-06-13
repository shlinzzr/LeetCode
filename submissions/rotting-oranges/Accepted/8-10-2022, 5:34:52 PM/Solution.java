// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        Queue<int[]> qq = new LinkedList<>();
        
        
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                if(grid[r][c]==2)
                    qq.offer(new int[]{c, r, 0});
            }
        }
        
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        
        int cnt = 0;
        while(!qq.isEmpty()){
            int[] p = qq.poll();
            
            // System.out.println("x=" + p[0] + " y=" + p[1] + " lv=" + p[2]);
            
            for(int[] d : dirs){
                int px = p[0] + d[0];
                int py = p[1] + d[1];
                int lv = p[2] + 1;
                
                if(px<0 || px>=w || py<0 || py>=h || grid[py][px]!=1)
                    continue;

                grid[py][px]=2;
                qq.offer(new int[]{px, py, lv});
                cnt = Math.max(cnt, lv);
            }
        }
        
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                if(grid[r][c]==1)
                    return -1;
            }
        }
        
        
        
        
        return cnt;
        
        
        
    }
}