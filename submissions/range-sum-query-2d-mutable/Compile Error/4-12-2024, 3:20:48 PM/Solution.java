// https://leetcode.com/problems/range-sum-query-2d-mutable

class NumMatrix {

    int[][] mat;
    int h;
    int w;
    int[] dp;

    public NumMatrix(int[][] matrix) {

        this.mat = matrix;
        h=mat.length;
        w= mat[0].length;
        dp = new int[h][w];
        
    }
    
    public void update(int row, int col, int val) {
        mat[row][col] = val;

        helper();
    }

    private void helper(){

        for(int i=1; i<h; i++){
            mat[i] += mat[i-1];
        }

        for(int j=1; j<w; j++){
            mat[j] += mat[j-1];
        }

        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                
            }
        }


    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(i==0 && j==0){
                    dp[i][j] = mat[i][j];

                } 
                if(i>0) dp[i][j] = dp[i-1][j];
                if(j>0) dp[i][j] += dp[i][j-1];
                if(i>0 && j>0) dp[i][j] += dp[i-1][j-1];
            }
        }

        return dp[]
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */