// https://leetcode.com/problems/toeplitz-matrix

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int min = Math.min(h, w);
        // int max = Math.max(h, w);
        
        
        for(int i=0; i<h; i++){

            int ele = matrix[i][0];
            
            for(int d=0;d<min; d++){
                
                if((d+i)<h && d<w){
                    if(matrix[i+d][d]!=ele)
                        return false;
                }
            }
        }
        
        for(int j=0; j<w; j++){

            int ele = matrix[0][j];
            
            for(int d=0;d<min; d++){
                
                if((d+j)<w && d<h){
                    if(matrix[d][d+j]!=ele)
                        return false;
                }
            }
        }
        
        return true;
        
    }
}