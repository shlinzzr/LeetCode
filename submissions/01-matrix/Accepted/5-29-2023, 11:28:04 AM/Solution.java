// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;

        boolean[][] bool = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0){
                    q.offer(new int[]{i, j});
                    bool[i][j]=true;
                }
            }
        }
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        int[][] res = new int[h][w];

        int step=0;
        
        while(!q.isEmpty()){
            
            int siz = q.size(); 
            for(int i=0; i<siz; i++){
                int[] p = q.poll();
                
                res[p[0]][p[1]] = step;
                
                for(int[] d : dirs ){

                    int r = d[0]+p[0];
                    int c = d[1]+p[1];

                    if(r<0 || c<0 || r>=h || c>=w || bool[r][c] || mat[r][c]==0) 
                        continue;
                    
                    bool[r][c] = true;
                    q.offer(new int[]{r,c});

                }
            }
            step++;
            
        }
        
        return res;
            
    }
}