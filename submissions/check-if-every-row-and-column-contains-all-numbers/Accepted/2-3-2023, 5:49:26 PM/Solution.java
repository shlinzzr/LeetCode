// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers

class Solution {
    public boolean checkValid(int[][] matrix) {
        int h = matrix.length;
        int w = matrix.length;
        
        
        
        for(int i=0; i<h; i++){
            
            boolean[] row = new boolean[h];
            boolean[] col = new boolean[h];
            
            for(int j=0; j<w; j++){
                
                row[matrix[j][i]-1]=true;
                col[matrix[i][j]-1]=true;
            }
            
            
            for(int j=0; j<h; j++){
                if(row[j]==false)
                    return false;
                
                if(col[j]==false)
                    return false;
            }
            
        }
        
        return true;
    }
    
    
}