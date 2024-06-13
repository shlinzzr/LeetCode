// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;

        int st = 0, ed = h-1;

        while(st<ed){ // 0, 1
            int m = ed-(ed-st)/2;  // 1

            if(matrix[m][0]>target){
                ed = m-1; //0
            }else{
                st = m; //1
            }
        }

        int row = st;

        st=0; ed = w-1;

        while(st<ed){
            int m = st+(ed-st)/2;

            if(matrix[row][m]==target) 
                return true;
            else if(matrix[row][m]>target){
                ed = m-1;

            }   else
                st = m+1;
        }

        return matrix[row][st]==target;
    }
}