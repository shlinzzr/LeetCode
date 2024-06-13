// https://leetcode.com/problems/n-queens-ii

class Solution {
    
    int res = 0;
    char[][] mat ;
    public int totalNQueens(int n) {
        
        mat = new char[n][n];
        
        for(char[] arr : mat){
            Arrays.fill(arr, '.');
        }
        
        helper(0, n);
        
        return res;
    }
    
    private void helper(int i, int n){
        
        if(i==n){
            res++;
            return;
        }
        
        for(int j=0; j<n; j++){
            
            if(isValid(i, j, n)){
                mat[i][j]='Q';
                helper(i+1, n);
                mat[i][j] = '.';
            }
        }
    }
    
    private boolean isValid(int i, int j, int n){
        
        for(int k=0; k<n; k++){
            if(mat[i][k]=='Q') return false;
            if(mat[k][j]=='Q') return false;
        }
        
        int k=0;
        while(i-k>=0 && j-k>=0){
            if(mat[i-k][j-k]=='Q') return false;
            k++;
        }
        
        
        k=0;
        while(i-k>=0 && j+k<n){
            if(mat[i-k][j+k]=='Q') return false;
            k++;
        }
        
        return true;
        
        
    }
}