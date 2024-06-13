// https://leetcode.com/problems/rotate-image

class Solution {
    public void rotate(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        /*
        
        [[1,2,3]
        ,[4,5,6]
        ,[7,8,9]]
        
        x-y swap
        1 4 7
        2 5 8
        3 6 9
        
        xswap
        [[7,4,1]
        ,[8,5,2]
        ,[9,6,3]]
        
        */
        
        for(int i=0; i<h; i++){
            for(int j=0; j<i; j++){
                
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
                
            }
        }
        
        // for(int i=0; i<h; i++){
        //     for(int j=0; j<w; j++){
        //         System.out.print( matrix[i][j]+ " ,");
        //     }
        //     System.out.println();
        // }
        
        for(int i=0; i<h; i++){
            int st=0, ed=w-1;
            while(st<ed){
                int t = matrix[i][st];
                matrix[i][st] = matrix[i][ed];
                matrix[i][ed] = t;
                st++;
                ed--;
            }
        }
        
        
    }
}