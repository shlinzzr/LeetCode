// https://leetcode.com/problems/n-queens-ii

class Solution {
    int res =0;
    char[][] board;
    public int totalNQueens(int n) {
    
        board = new char[n][n];
        for(char[] b : board){
            Arrays.fill(b, '.');
        }
        dfs(0);
            
        return res;
    }
    
    private void dfs(int i){
        
        if(i==board.length){
            res++;
            return;
        }
        
        for(int j=0; j<board.length; j++){
            if(isValid(i, j)){
                board[i][j]='Q';
                dfs(i+1);
                board[i][j]='.';
            }
        }
    }
    
    private boolean isValid(int r, int c){
        
        for(int i=0;i<r;i++){
            if(board[i][c]=='Q') return false;
            if(board[r][i]=='Q') return false;
        }
        int k=1;
        while(r-k>=0 && c-k>=0){
            if(board[r-k][c-k]=='Q') return false;
            k++;
        }
        k=1;
        while(r-k>=0 && c+k<board.length){
            if(board[r-k][c+k]=='Q') return false;
            k++;
        }
        return true;
        
        
    }
}