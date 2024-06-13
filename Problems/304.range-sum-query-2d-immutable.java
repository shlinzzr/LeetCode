// https://leetcode.com/problems/range-sum-query-2d-immutable

class NumMatrix {


    int[][] presum;
    public NumMatrix(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        presum = new int[h+1][w+1];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                presum[i+1][j+1] = matrix[i][j] + presum[i][j+1]+ presum[i+1][j] - presum[i][j];    
            }            
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int rmax = Math.max(row1, row2);
        int rmin = Math.min(row1, row2);

        int cmax = Math.max(col1, col2);
        int cmin = Math.min(col1, col2);

        return presum[rmax+1][cmax+1] - presum[rmax+1][cmin] - presum[rmin][cmax+1] + presum[rmin][cmin];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */