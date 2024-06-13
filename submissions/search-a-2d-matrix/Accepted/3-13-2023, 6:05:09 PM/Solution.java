// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        int r =0;
        for(int i=0; i<h; i++){
            if(matrix[i][w-1]<target) // check last row
                r++;
            else 
                break;
        }
        
        if(r>=h)
            return false;
        
        for(int j=0; j<w; j++){
            if(matrix[r][j]==target)
                return true;
            else if(matrix[r][j]>target)
                break;
        }
        
        return false;
    }
}