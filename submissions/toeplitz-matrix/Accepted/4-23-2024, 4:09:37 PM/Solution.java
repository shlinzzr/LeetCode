// https://leetcode.com/problems/toeplitz-matrix

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        
        for(int i=0; i<h; i++){
            boolean rt = checkDia(matrix, i, 0);
            if(rt==false) return false;
        }
        
        for(int j=1; j<w; j++){
            boolean rt = checkDia(matrix, 0, j);
            if(rt==false) return false;
        }
        
        return true;
        
    }
    
    private boolean checkDia(int[][] matrix, int i, int j){
        
        int h = matrix.length;
        int w = matrix[0].length;
        int val = matrix[i][j];
        for(int r=i+1, c=j+1; r<h&&c<w; r++,c++){
            if(matrix[r][c]!=val) return false;
        }
        return true;
    }
}