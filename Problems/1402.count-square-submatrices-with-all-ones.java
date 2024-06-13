// https://leetcode.com/problems/count-square-submatrices-with-all-ones

class Solution {
    public int countSquares(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] presum = new int[h+1][w+1];

        int res = 0 ;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(matrix[i][j]>0)
                presum[i+1][j+1] = Math.min(presum[i][j+1], Math.min(presum[i+1][j], presum[i][j])) +1;

                res += presum[i+1][j+1];
                
            }
        }

        return res;
        
    }
}