// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int h = mat.length;
        int w = mat[0].length;
        
        int[][] res = new int[h][w];
        
        for(int i=0;i<h;i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]!=0){
                    // System.out.println("bfs " + i + "," + j);
                    bfs(mat, res, new int[]{i,j});
                    
                }
            }
        }
        
        return res;
        
    }
    
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    
    private void bfs(int[][] mat, int[][] res, int[] axis){
        
        int h = res.length;
        int w = res[0].length;
        
        boolean[][] visited = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(axis);
        
        int cnt=1;
        
        while(!q.isEmpty()){
            
            int siz = q.size();
            for(int i=0; i<siz; i++){
                int[] p = q.poll();
                visited[axis[0]][axis[1]]=true;
                // System.out.println("p= " + p[0] + ", " + p[1]);
                
            
                for(int[] d : dirs){

                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    
                    if(r>=0 && r<h && c>=0 && c<w && visited[r][c]==false){
                                             
                        visited[r][c]=true;
                        if(mat[r][c]==0){
                            res[axis[0]][axis[1]] = cnt;
                            return;
                        }
                        
                        if(res[r][c]>0)
                            res[axis[0]][axis[1]] = res[r][c] + cnt;
                        else
                            q.offer(new int[]{r,c});
                    }
                }
            }
            
            cnt++;
        }
        
        
    }
}