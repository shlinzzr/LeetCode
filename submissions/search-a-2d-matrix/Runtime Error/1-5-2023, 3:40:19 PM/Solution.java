// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int r =0;
        for(int i=0; i<m; i++){
            if(matrix[i][n-1]<target) // 7<3. // 7<7
                r++;
            else 
                break;
        }
        
        for(int j=0; j<n; j++){
            if(matrix[r][j]==target)
                return true;
            else if(matrix[r][j]>target)
                break;
        }
        
        return false;
    }
}