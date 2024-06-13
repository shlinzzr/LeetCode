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
        
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || bool[i][j]==true)
            
            return -1;
   
        bool[i][j] = true;
        
        if(mat[i][j]==0)
            return d;
        
        
        int distance = Integer.MAX_VALUE;
        
        
        
        int down = bfs(mat, bool, i+1, j, d+1);
        int u = bfs(mat, bool, i-1, j, d+1);
        int r = bfs(mat, bool, i, j+1, d+1);
        int l = bfs(mat, bool, i, j-1, d+1);
        
         if(down!=-1)
            distance = Math.min(distance, down);
         if(u!=-1)
            distance = Math.min(distance, u);
         if(r!=-1)
            distance = Math.min(distance, r);
         if(l!=-1)
            distance = Math.min(distance, l);
        
        
        
        
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