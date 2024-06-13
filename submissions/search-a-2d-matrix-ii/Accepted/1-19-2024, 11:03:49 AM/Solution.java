// https://leetcode.com/problems/search-a-2d-matrix-ii

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int i=0, j=w-1;
        
        while(i<h && j>=0){
            
            if(matrix[i][j]==target)
                return true;
            
            else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        
        return false;
        
    }
}