// https://leetcode.com/problems/range-sum-query-2d-mutable

class NumMatrix {

    int[][] presumRow;
    public NumMatrix(int[][] matrix) {

        int h = matrix.length;
        int w = matrix[0].length;
        presumRow = new int[h][w];
        for(int i=0; i<h;i++){
            System.arraycopy(matrix[i],0, presumRow[i], 0, w);
        }


        // presumRow = matrix;
        for(int i=0; i<h; i++) {
            for(int j=0; j<presumRow[0].length; j++) {
                presumRow[i][j] += j==0 ? 0 :  presumRow[i][j-1] ;
            }
        }
    }
    
    public void update(int row, int col, int val) {

        int prevVal = (col == 0 ? presumRow[row][col] : presumRow[row][col] - presumRow[row][col-1]);
        int diff = val - prevVal;
        
        for(int j=col; j<presumRow[0].length; j++) {
            presumRow[row][j] += diff;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for(int i=row1; i<=row2; i++) {
            result += presumRow[i][col2] - (col1 == 0 ? 0 : presumRow[i][col1-1]);
        }
        return result;
    }
}