// https://leetcode.com/problems/rotate-image

class Solution {
    public void rotate(int[][] matrix) {
        int h= matrix.length;
        int w = matrix[0].length;
        
     
     // x-y mirror
       for(int i=0; i<h;i++){
            for(int j=0;j<=i; j++){
                
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp ;
                
            }
        }
        
        
        
        // x mirror
        for(int i=0; i<h;i++){
            for(int j=0; j<w/2; j++){
                
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][w-j-1];
                matrix[i][w-j-1] = tmp;
            }
        }
        
        
    }
        
}