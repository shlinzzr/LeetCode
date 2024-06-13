// https://leetcode.com/problems/01-matrix

class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int h = mat.length;
//         int w = mat[0].length;
        
//         Queue<int[]> queue = new LinkedList<>();
        
//         for(int i=0; i<h; i++){
//             for(int j=0; j<w; j++){
                
//                 if(mat[i][j]==0)
//                     queue.offer(new int[]{j, i});
                
//                 else{
//                     mat[i][j]=Integer.MAX_VALUE;
//                 }
//             }
//         }
        
//         int[][] dirs = new int[][]{{0,1} , {0,-1}, {1, 0}, {-1, 0}};
        
//         while(queue.size()>0){
//             int[] cell = queue.poll();
//             for(int[] d : dirs){
//                 int r = cell[0] + d[0];
//                 int c = cell[1] + d[1];
//                 if(r<0 || r>=h || c<0 || c>=w || mat[r][c] <= mat[cell[0]][cell[1]]+1)
//                     continue;
//                 queue.offer(new int[]{r,c});
//                 mat[r][c] = mat[cell[0]][cell[1]]+1;
//             }
//         }
        
//         return mat;
// }
    
    public int[][] updateMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
        return matrix;
    }
    int[][] dis = new int[matrix.length][matrix[0].length];
    int range = matrix.length * matrix[0].length;
    
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                dis[i][j] = 0;
            } else {
                int upCell = (i > 0) ? dis[i - 1][j] : range;
                int leftCell = (j > 0) ? dis[i][j - 1] : range;
                dis[i][j] = Math.min(upCell, leftCell) + 1;
            }
        }
    }
    
    for (int i = matrix.length - 1; i >= 0; i--) {
        for (int j = matrix[0].length - 1; j >= 0; j--) {
            if (matrix[i][j] == 0) {
                dis[i][j] = 0;
            } else {
                int downCell = (i < matrix.length - 1) ? dis[i + 1][j] : range;
                int rightCell = (j < matrix[0].length - 1) ? dis[i][j + 1] : range;
                dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]);
            }
        }
    }
    
    return dis;
}
    
}