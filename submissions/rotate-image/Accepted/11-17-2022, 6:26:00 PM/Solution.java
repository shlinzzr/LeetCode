// https://leetcode.com/problems/rotate-image

class Solution {
    public void rotate(int[][] matrix) {
        
        int h= matrix.length;
        int w = matrix[0].length;

        //(0, 0) => (w, 0)
        //(1, 0) => (w, 1)
        //(0, 1) => (w-1, 0)
        
        //  1. xy 互換
        // 1 4 7
        // 2 5 8
        // 3 6 9
        
        //2. 0, w-1 互換
        
        
        
        for(int i=0; i<h;i++){
            for(int j=i+1;j<w; j++){
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp ;
                
            }
        }
        
        // for(int i=0; i<h;i++){
        //     for(int j=0;j<w; j++){
        //         System.out.println("matrix["+i + "][" + j + "]= " + matrix[i][j] );
        //     }
        // }
        
        
        for(int i=0; i<h;i++){
            for(int j=0;j<w/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][w-1-j];
                matrix[i][w-1-j] = temp;
            }
        }
        
        
        
    }
}