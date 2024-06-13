// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;

        int[][] res = new int[h][w];
        for(int i=0; i<h;i++){
            Arrays.fill(res[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){

                int[] p = q.poll();

                int y = p[0];
                int x = p[1];

                res[y][x] = step;

                for(int[] d: dirs){
                    int r = y+d[0];
                    int c = x+d[1];

                    if(r<0 || c<0 || r>=h || c>=w || mat[r][c]==0 || res[r][c]!=-1) continue;

                    q.offer(new int[]{r,c});
                }                
            }
            step++;
        }
        
        return res;
            
    }
}