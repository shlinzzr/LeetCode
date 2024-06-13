// https://leetcode.com/problems/range-sum-query-2d-immutable

class NumMatrix {

    int[][] arr;
    int h;
    int w;
    
    public NumMatrix(int[][] matrix) {
        h = matrix.length;
        w = matrix[0].length;
        arr = new int[h][w];
        
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                
                arr[i][j] = matrix[i][j];
                
                if(i>0)
                    arr[i][j] += arr[i-1][j];
                
                if(j>0)
                    arr[i][j] += arr[i][j-1];
                
                if(i>0 && j>0)
                    arr[i][j] -= arr[i-1][j-1];
            }
        }
        
        
        for(int[] ar : arr){
            for(int a : ar){
                System.out.print(a+",");
            }
            System.out.println();
        }
        
        
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
         row1--;
        col1--;
        row1 = Math.max(row1, 0);
        row1 = Math.min(row1, h-1);
        
        col1 = Math.max(col1, 0);
        col1 = Math.min(col1, w-1);
        
        row2 = Math.max(row1+row2, 0);
        row2 = Math.min(row1+row2, h-1);
        
        col2 = Math.max(col1+col2, 0);
        col2 = Math.min(col1+col2, w-1);
        
      
        
        int sum = 0;
        
        if(row2>=0 && col2>=0) sum +=arr[row2][col2]  ;
        System.out.println("total=" +sum);
        System.out.println(row1 +" " + col1);
        System.out.println(row2 +" " + col2);
        
        
        if(row1>=0){
            System.out.println("up=" + arr[row1][col2]);
            sum -= arr[row1][col2];
        }
        if(col1>=0){
            System.out.println("left="+  arr[row2][col1]);
            sum -= arr[row2][col1];
        }
        if(row1>=0 && col1>=0) {
            System.out.println("up left="+  arr[row1][col1]);
            sum += arr[row1][col1];
        }
        
        return sum;
        
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */