// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {

         int h = matrix.length;
         int w = matrix[0].length;


        boolean first_row_zero = false;
        boolean first_col_zero = false;
         for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    if(i==0) first_row_zero =true;
                    if(j==0) first_col_zero =true;
                }
            }
         }

        /* start from one here */
        for(int j=1; j<w; j++){
            if(matrix[0][j]==0){
                for(int i=0; i<h; i++){
                    matrix[i][j] = 0;
                }
            }   
        }

        /* start from one here */
        for(int i=1; i<h; i++){
            if(matrix[i][0]==0){
                for(int j=0; j<w; j++){
                    matrix[i][j]=0;
                }
            }
        }

        if(first_row_zero){
            for(int j=0; j<w; j++){
                matrix[0][j]=0;
            }
        }

        if(first_col_zero){
            for(int i=0; i<h; i++){
                matrix[i][0] = 0;
            }
        }

        
    }
}