// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
     
        int h = mat.length;
        int w = mat[0].length;
        
        int[][] res = new int[h][w];
        for(int[] r : res){
            Arrays.fill(r, Integer.MAX_VALUE);    
        }
        
        boolean[][] bool = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    bool[i][j]=true;
                }
            }
        }
        
        bfs(q, mat, bool, res);
        
        return res;
    }
    
    int[][] dirs = new int[][]{{0,1},{0,-1}, {1,0}, {-1,0}};
    private void bfs( Queue<int[]> q, int[][] mat, boolean[][]bool, int[][] res){
        
        int h = mat.length;
        int w = mat[0].length;
        int step=0;
        
        while(!q.isEmpty()){
            for(int ss=q.size(); ss>0; ss--){
                int[] p = q.poll();
                
                res[p[0]][p[1]]= step;
                
                
                for(int[] d : dirs){
                    int r = p[0] + d[0];
                    int c = p[1] + d[1];
                    
                    if(r>=0 && r<h && c>=0 && c<w && bool[r][c]==false){
                        
                        bool[r][c]=true;
                        q.offer(new int[]{r,c});
                    }
                }
            }
            step++;
        }
    }
}