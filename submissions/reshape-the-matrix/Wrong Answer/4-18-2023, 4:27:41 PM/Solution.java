// https://leetcode.com/problems/reshape-the-matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        if(m==r && n==c)
            return mat;
        
        int[][] res = new int[r][c];
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
                
//                 int t = i*n + j;
//                 int y = t/r;
//                 int x = t%r;
//                 res[y][x] = mat[i][j];
                
//             }
//         }
        
        for(int i=0; i<m*n; i++){
            
            int ox = i%n;
            int oy = i/n;
            
            int x = i%c;
            int y = i/c;
            
            res[y][x] = mat[oy][ox];
            
            
            
            
            
        }
        
        return res;
        
    }
}