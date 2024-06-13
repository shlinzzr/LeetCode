// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int h = mat.length;
        int w = mat[0].length;
        
        int[][] res = new int[h][w];
        
        for(int i=0;i<h;i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]!=0)
                    res[i][j] = bfs(mat, res, new int[]{i,j});
            }
        }
        
        return res;
        
    }
    
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    
    private int bfs(int[][] mat, int[][] res, int[] axis){
        
        int h = res.length;
        int w = res[0].length;
        
        boolean[][] visited = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(axis);
        int cnt=0;
        
        while(!q.isEmpty()){
            
            int siz = q.size();
            for(int i=0; i<siz; i++){
                axis = q.poll();
            
                for(int[] d : dirs){

                    int r = axis[0]+d[0];
                    int c = axis[1]+d[1];
                    
                    if(r>=0 && r<h && c>=0 && c<w && visited[r][c]==false){
                        
                        visited[r][c]=true;
                        
                        if(mat[r][c]==1)
                            return cnt;
                        
                        q.offer(new int[]{r,c});
                    }
                }
            }
            
            cnt++;
        }
        
        return -1;
        
    }
}