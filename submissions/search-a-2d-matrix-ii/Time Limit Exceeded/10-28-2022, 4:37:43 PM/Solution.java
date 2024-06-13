// https://leetcode.com/problems/search-a-2d-matrix-ii

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int r=0, c=0, pr=-1, pc=-1;
        
        while(r!=pr && c!=pc){
            pc=c;
            pr=r;
            
            r = findRow(matrix, target, pc);
            c = findCol(matrix, target, pr);
            
            if(matrix[r][pc] ==target || matrix[pr][c]==target || matrix[r][c]==target)
                return true;
            
          
        }
        
        return false;
        
        
        
        
    }
    
    
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
        return st;
        
    }
}