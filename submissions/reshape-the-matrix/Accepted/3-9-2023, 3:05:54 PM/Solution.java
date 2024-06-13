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
            
            int ox = i % n;
            int oy = i / n;
            // System.out.println(i+", "+y+ " "+x+ ", " + oy + " " + ox);
            res[y][x] = mat[oy][ox];
        }
        return res;
        
    }
}