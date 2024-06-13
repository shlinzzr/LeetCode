// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        
        int h=mat.length;
        int w=mat[0].length;
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w;j++){
                
                if(mat[i][j]==0)
                    continue;
                
               boolean[][] bool = new boolean[h][w];
                mat[i][j] = bfs(mat, bool, i, j, 0);
                
            }   
        }
        
        return mat;
        
    }
    
    
    private int bfs(int[][] mat,  boolean[][] bool, int i, int j, int d){
        
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length||bool[i][j]==true)
            
            return d;
   
        bool[i][j] = true;
        
        int down = bfs(mat, bool, i+1, j, d+1);
        int u = bfs(mat, bool, i-1, j, d+1);
        int r = bfs(mat, bool, i, j+1, d+1);
        int l = bfs(mat, bool, i, j-1, d+1);
        
        int tmpA = Math.min(down,u);
        int tmpB = Math.min(r,l);
        int distance = Math.min(tmpA, tmpB);
        
        
        return distance;
        
        // Queue<int[]> queue = new LinkedList<>();
        // queue.offer(new int[]{j, i});
        
        
//         while(!queue.isEmpty()){
//             int[] p = queue.poll();
//             int px = p[0];
//             int py = p[1];
            
//             if(mat[py][px]) 
            
//         }
        
    }
}