// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        int max = 0;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                int res = bfs(matrix, i, j);   
                max = Math.max(max, res);
            }
        }

        return max;

        
    }

    private int bfs(int[][] matrix, int i, int j){
        int h = matrix.length;
        int w = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j} );

        Set<String> seen = new HashSet<>();
        seen.add(i + "_"+ j);
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){

                int[] p = q.poll();

                for(int[] d: dirs){
                    int r = d[0]+p[0];
                    int c = d[1]+p[1];

                    if(r<0 || c<0 || r>=h || c>=w || matrix[r][c]<= matrix[p[0]][p[1]]) continue;
                    if(seen.add(r+"_"+c)==false) continue;
                    q.offer(new int[]{r,c});
                }

            }
            step++;
        }

        return step;
    }
}