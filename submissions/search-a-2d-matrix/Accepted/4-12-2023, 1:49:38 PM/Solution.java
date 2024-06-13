// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        int st = 0, ed = h*w-1;
        while(st<=ed){
            // System.out.println(st + " "  + ed);
            
            int mid = st+(ed-st)/2;
            int r = mid/w;
            int c = mid%w;
            
            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]>target){
                ed= mid-1;
            }else{
                st= mid+1;
            }
        }
        
        
        
        
        return false;
        
        
        
    }
}