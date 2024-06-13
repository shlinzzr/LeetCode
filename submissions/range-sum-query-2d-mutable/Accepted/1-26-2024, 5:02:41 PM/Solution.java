// https://leetcode.com/problems/range-sum-query-2d-mutable

class NumMatrix {

    int[][] mat;
    int h;
    int w;
    
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        h = matrix.length;
        w = matrix[0].length;
        
    }
    
    public void update(int row, int col, int val) {
        mat[row][col] = val;
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum=0;
        
        for(int i=row1; i<=row2; i++){
            for(int j=col1; j<=col2; j++){
                
                sum += mat[i][j];
            }
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */