// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int h = mat.length;
        int w = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0)
                    queue.offer(new int[]{i, j});
                else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] d : dirs){
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if(r<0 || r>=h || c<0 || c>=w || mat[r][c]<= mat[cell[0]][cell[1]]+1)
                    continue;
                queue.offer(new int[]{r,c});
                mat[r][c] = mat[cell[0]][cell[1]]+1;
            }
        }
        
        
        return mat;
        
    }
        
}