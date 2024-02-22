// https://leetcode.com/problems/count-square-submatrices-with-all-ones

class Solution {
    public int countSquares(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                matrix[i][j] = matrix[i][j]==0? 0 : 1+Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
            }
        }
        
        int res = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                // System.out.print(matrix[i][j] + " ,");
                
                res += matrix[i][j];
            }
            // System.out.println();
        }
        
        return res;
        
        
        
    }

    
    /*
    
  [0,1,1,1],
  [1,1,2,2],
  [0,1,2,3]
  */
    
}