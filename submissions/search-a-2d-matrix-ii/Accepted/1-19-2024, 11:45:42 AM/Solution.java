// https://leetcode.com/problems/search-a-2d-matrix-ii

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int i=h-1, j=0;//左下走到右上 
        
        while(j<w && i>=0){
            
            if(matrix[i][j]==target)
                return true;
            
            else if(matrix[i][j]>target){
                i--;
            }else{
                j++;
            }
        }
        
        return false;
        
    }
}