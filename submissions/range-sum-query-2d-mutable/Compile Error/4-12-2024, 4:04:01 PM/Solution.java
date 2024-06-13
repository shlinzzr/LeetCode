// https://leetcode.com/problems/range-sum-query-2d-mutable

class NumMatrix {

    int[][] presumRow;
    int h;
    int w;
    public NumMatrix(int[][] matrix) {
        presumRow = matrix;
        for(int i=0; i<h; i++) {
            for(int j=1; j<w; j++) {
                mat[i][j] += mat[i][j-1]; 
            }
        }
    }
    
    public void update(int row, int col, int val) {
        
        int prevVal = (col == 0 ? mat[row][col] : mat[row][col] - mat[row][col-1]);
        int diff = val - prevVal;
        
        for(int i=col; i<mat[0].length; i++) {
            mat[row][i] += diff;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for(int i=row1; i<=row2; i++) {
            result += mat[i][col2] - (col1 == 0 ? 0 : mat[i][col1-1]);
        }
        return result;
    }
}