// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean first_row_zero = false;
        boolean first_col_zero = false;
        
        
         for(int i=0; i<m; i++){
              if(matrix[i][0]==0)
                    first_col_zero=true;
             
         }
        
         for(int j=0; j<n; j++){
               if(matrix[0][j]==0)
                    first_row_zero=true;
          }
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            
            if(matrix[i][0]==0 || (i==0 && first_row_zero)){
                for(int j=0; j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        
        for(int j=0; j<n;j++){        
            if(matrix[0][j]==0 || (j==0 && first_col_zero)){
                for(int i=0; i<m; i++){
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}