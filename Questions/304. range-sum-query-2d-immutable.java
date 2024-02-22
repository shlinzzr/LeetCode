// https://leetcode.com/problems/range-sum-query-2d-immutable

class NumMatrix {

    int[][] arr;
    int h;
    int w;
    
    public NumMatrix(int[][] matrix) {
        h = matrix.length;
        w = matrix[0].length;
        arr = new int[h+1][w+1];
        
        for(int i=1; i<=h; i++){
            
            for(int j=1; j<=w; j++){
                
                arr[i][j] = matrix[i-1][j-1] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }
        
    }
     public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);

        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);

        return arr[iMax + 1][jMax + 1] - arr[iMax + 1][jMin] - arr[iMin][jMax + 1] + arr[iMin][jMin];    
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */