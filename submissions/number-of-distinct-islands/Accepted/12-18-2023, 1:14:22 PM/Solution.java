// https://leetcode.com/problems/number-of-distinct-islands

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        boolean[][] seen = new boolean[h][w];

        Queue<int[]> q = new LinkedList<>();

        Set<String> set = new HashSet<>();
        int cnt = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==1 && seen[i][j]==false) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, seen, sb);
                    set.add(sb.toString());
                    cnt++;
                }
            }
        }

        return set.size();
    }

    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0},{0,-1}};

    private void dfs(int[][] grid, int i, int j, boolean[][] seen, StringBuilder sb){
        int h = grid.length;
        int w = grid[0].length;


        sb.append("0_0");

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        seen[i][j] = true;


        
        while(!q.isEmpty()){
            int[] p = q.poll();

            for(int[] d : dirs){
                int r = d[0]+p[0];
                int c = d[1]+p[1];

                if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || grid[r][c]==0)
                    continue;
                
                sb.append( "," + (r-i) + "_" + (c-j));
                seen[r][c] = true;
                q.offer(new int[]{r,c});
            }
        }

    }
}