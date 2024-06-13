// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        int cnt =0;
        boolean[][] seen = new boolean[h][w];
        for(int i=0; i<h;i ++){
            for(int j=0; j<w; j++){
                if(seen[i][j]==false && grid[i][j]=='1'){
                    bfs(grid, i, j, seen);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] seen){
        int h = grid.length;
        int w = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        seen[i][j] =true;

        int[][] dirs = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){

            int[] p = q.poll();
            for(int[] d: dirs){
                int r = p[0] + d[0];
                int c = p[1] + d[1];
                if(r<0 || c<0 || r>= h|| c>=w || seen[r][c] || grid[r][c]=='0')
                    continue;

                seen[r][c] = true;
                q.offer(new int[]{r,c});
            }
        }

    }
}