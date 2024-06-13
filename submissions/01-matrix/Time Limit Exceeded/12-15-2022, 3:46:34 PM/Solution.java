// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
     
        int h = mat.length;
        int w = mat[0].length;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==1){
                    bfs(mat, i, j, new boolean[h][w]);    
                }
            }
        }
        return mat;
    }
    
    int[][] dirs = new int[][]{{0,1},{0,-1}, {1,0}, {-1,0}};
    private void bfs(int[][] mat, int i, int j, boolean[][]bool){
        
        int h = mat.length;
        int w = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        bool[i][j] = true;
        int step=0;
        
        while(!q.isEmpty()){
            for(int ss=q.size(); ss>0; ss--){
                int[] p = q.poll();
                
                
                if(mat[p[0]][p[1]]==0){
                    mat[i][j]=step;
                    return;
                }
                    
                
                
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