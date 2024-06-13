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
    
     /*
    [[ 1, 4, 7, 11, 15],
     [ 2, 5, 8, 12, 19],
     [ 3, 6, 9, 16, 22],
     [10,13,14, 17, 24],
     [18,21,23, 26, 30]]
     
    20
    [[1,2,3,4,5],
     [6,7,8,9,10],
     [11,12,13,14,15],
     [16,17,18,19,20],
     [21,22,23,24,25]]
19


 [[1,3,5,7,9]
,[2,4,6,8,10]
,[11,13,15,17,19]
,[12,14,16,18,20]
,[21,22,23,24,25]]
13
    */
    
    private int findRow(int[][] matrix, int target, int j){
        int h = matrix.length;
        int w = matrix[0].length;
        
        int st=0, ed=h-1;
        while(st<ed){
            int mid = st + (ed-st)/2;
            
            if(matrix[mid][j]==target)
                return mid;
            
            else if(matrix[mid][j]>target)
                
                ed=mid-1;
            else
                st=mid+1;
        }
        
        if(st>0 && matrix[st][j]>target)
            return st-1;
        
        return st;
        
    }
    
     private int findCol(int[][] matrix, int target, int i){
        int h = matrix.length;
        int w = matrix[0].length;
        
        int st=0, ed=w-1;
        while(st<ed){
            int mid = st + (ed-st)/2;
            
            if(matrix[i][mid]==target)
                return mid;
            
            else if(matrix[i][mid]>target)
                
                ed=mid-1;
            else
                st=mid+1;
        }
         
        if(st>0 && matrix[i][st]>target)
            return st-1;
         
        return st;
        
    }
    
   
}