// https://leetcode.com/problems/01-matrix

class Solution {
    
     int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    
    public int[][] updateMatrix(int[][] mat) {
        
        int h = mat.length;
        int w = mat[0].length;
        
        int[][] res = new int[h][w];
        boolean[][] visited = new boolean[h][w];
        
        
          
        Queue<int[]> q = new LinkedList<>();
        
        
        for(int i=0;i<h;i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    
                }
            }
        }
        int cnt=1;
        while(!q.isEmpty()){
            
            int siz = q.size();
            for(int i=0; i<siz; i++){
                int[] p = q.poll();
            
                for(int[] d : dirs){

                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    
                    if(r<0 || r>=h || c<0 || c>=w || visited[r][c]==true)
                        continue;
                    
                    visited[r][c]=true;
                    q.offer(new int[]{r,c});
                    res[r][c] = cnt;
                }
            }
            
            cnt++;
        }
        
        return res;
        
    }
}