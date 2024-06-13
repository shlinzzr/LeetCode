// https://leetcode.com/problems/maximal-square

class Solution {
    
    int maxLen=0;
    
    public int maximalSquare(char[][] matrix) {

        int h=matrix.length;
        int w=matrix[0].length;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(matrix[i][j]=='1')
                    maxLen = Math.max(maxLen, 1);
                
                for(int k=1; k+i<h&&k+j<w; k++){
                    if(isValid(matrix, i, j, k)){ // i=1 j=2 k=2
                        System.out.println(isValid(matrix, i, j, k) + ", i=" + i + " j=" + j + " k=" + k);
                       maxLen = Math.max(maxLen, k+1);
                    }
                }
                
            }
        }
        return maxLen*maxLen;
        
    }
    
                       
    private boolean isValid(char[][] matrix, int i, int j, int k){
        
        for(int r=i; r<=i+k; r++){
            for(int c=j; c<=j+k; c++){
                
                if(matrix[r][c]=='0')
                    return false;
            }
        }
        
        return true;
    }               
                       
    
//     private boolean dfs(char[][] matrix, int i, int j){
        
//         if(i==matrix.length) return true;
//         if(j==matrix[0].length) return dfs(matrix, i+1, 0);
//     }
}