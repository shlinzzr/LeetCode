// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island

class Solution {
    public int minDays(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        int cnt = cntIsland(grid);
        if(cnt>1 || cnt==0) return 0;

        // find one connect
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(grid[i][j]==0) continue;
                grid[i][j]=0;
                cnt = cntIsland(grid);
                if(cnt>1 || cnt==0) return 1;
                grid[i][j] = 1;
            }
        }

        return 2;
        
    }

    private int cntIsland(int[][] grid){
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] seen = new boolean[h][w];
        int cnt=0;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(grid[i][j]==0) continue;
                if(seen[i][j]) continue;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                seen[i][j] = true;

                while(!q.isEmpty()){
                    int[] p = q.poll();

                    for(int[] d: dirs){
                        int r = d[0]+p[0];
                        int c = d[1] +p[1];
                        if(r<0 || c<0 || r>=h || c>=w) continue;
                        if(seen[r][c]) continue;
                        if(grid[r][c]==0) continue;

                        q.offer(new int[]{r,c});
                        seen[r][c] = true; 
                    }
                }
                cnt++;
                if(cnt>1) return 2;

            }
          
        }

        return cnt;


    }
}