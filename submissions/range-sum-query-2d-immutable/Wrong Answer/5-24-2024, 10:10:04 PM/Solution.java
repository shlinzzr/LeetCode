// https://leetcode.com/problems/range-sum-query-2d-immutable

class NumMatrix {

    int[][] presum;

    public NumMatrix(int[][] matrix) {
        int h= matrix.length; 
        int w = matrix[0].length;
        presum= new int[h][w];
        presum[0][0] = matrix[0][0];

        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                presum[i][j] =(i==0 || j==0) ? matrix[i][j] : presum[i-1][j] + presum[i][j-1]-presum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int all = presum[row2][col2];
        int up = row1==0 ? 0 : presum[row1-1][col2];
        int left = col1==0 ? 0 : presum[row2][col1-1];
        int upLeft = (row1==0 || col1==0 ? 0 : presum[row1-1][col1-1]);
        // int res = presum[row2][col2]-row1==0 ?  0 :presum[row1-1][col2] - col1==0 ? 0 : presum[row2][col1-1] + row1==0 || col1==0 ? 0 : presum[row1-1][col1-1];

        return all - up -left + upLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */