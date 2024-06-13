// https://leetcode.com/problems/reshape-the-matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        if(m*n!=r*c)
            return mat;
        
        int[][] res = new int[r][c];
        
        for(int i=0; i<m*n; i++){
            
            int x = i%c;
            int y = i/c;
            
            int ox = i % m;
            int oy = i / n;
            
            res[y][x] = mat[oy][ox];
        }
        return res;
        
    }
}