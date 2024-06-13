// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        boolean[] firstRow = new boolean[w];
        boolean[] firstCol = new boolean[h];
        
        for(int i=0;i<h; i++){
            if(matrix[i][0]==0){
                firstCol[i] = true;
            }
        }
        
        for(int j=0; j<w; j++){
            if(matrix[0][j]==0){
                firstRow[j]=true;
            }
        }
        
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        boolean firstColZero = false;
        boolean firstRowZero = false;
        
        for(int j=0; j<w; j++){
            
            if(firstRow[j]){
                firstRowZero = true;
                matrix[0][j]=0;
            }
            
            if(matrix[0][j]==0){
                for(int i=0; i<h; i++){
                    matrix[i][j]=0;
                }
            }
            
            
        }
        
        for(int i=0; i<h; i++){
            
            if(firstCol[i]){
                firstColZero=true;
                matrix[i][0]=0;
            }
            if(matrix[i][0]==0 ){
                for(int j=0;j<w; j++){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(firstColZero){
            for(int i=0; i<h; i++){
                matrix[i][0]=0;
            }
        }
        
        if(firstRowZero){
            for(int j=0; j<w;j++){
                matrix[0][j]=0;
            }
        }
        
        
        
    }
}