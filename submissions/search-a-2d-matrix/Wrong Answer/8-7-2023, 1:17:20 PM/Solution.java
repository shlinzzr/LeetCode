// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        int st=0, ed=h-1;
        
        while(st<ed){
            
            int mid = ed-(ed-st)/2;
            
            if(matrix[mid][0]>target){
                ed = mid-1;
            }else{
                st = mid;
            }
        }
        
        
        System.out.println(st);
            
        int row = st;
        st=0;
        ed=w-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(matrix[row][mid]==target){
                return true;
            }else if(matrix[row][mid]>target){
                st = mid+1;
            }else{
                ed= mid-1;
            }
        }
        
        return matrix[row][st]==target;        
    }
}