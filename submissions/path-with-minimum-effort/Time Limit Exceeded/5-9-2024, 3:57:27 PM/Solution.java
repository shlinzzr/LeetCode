// https://leetcode.com/problems/path-with-minimum-effort

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int h= heights.length;
        int w = heights[0].length;

        int[][] cost = new int[h][w];
        for(int i=0; i<h; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        // bfs

        Queue<int[]> q = new LinkedList<>(); // i, j, cost, res
        q.offer(new int[]{0, 0, 0, 0});

        int[][] dirs = new int[][]{{0,1}, {1,0},{0,-1},{-1,0}};
        int res = Integer.MAX_VALUE;
        while(!q.isEmpty()){

            int[] p = q.poll();
            cost[p[0]][p[1]] = p[2];

            if(p[0]==h-1 && p[1]==w-1){
                res = Math.min(res, p[3]);
                continue;
            }

            for(int[] d : dirs){
                int r = p[0] + d[0];
                int c = p[1] + d[1];
                if(r<0 || c<0 || r>=h || c>=w) continue;

                int diff = Math.abs(heights[r][c]-heights[p[0]][p[1]]);
                if(cost[r][c]<=p[2]+diff) continue;

                q.offer(new int[]{r,c, p[2]+diff, Math.max(diff, p[3])});

            }
        }

        return res;

        
    }
}