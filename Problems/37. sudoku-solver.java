// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        
        dfs(board, 0, 0);
        
    }
    
    private boolean dfs(char[][] board, int i, int j){
        if(i==9) return true;
        if(j==9) return dfs(board, i+1, 0);
        if(board[i][j]!='.')
            return dfs(board, i, j+1);
        
        for(char k='1'; k<='9'; k++){
            
            if(!isValid(board, i, j, k))
                continue;
            
            board[i][j]=k;
            if(dfs(board, i, j+1)==true)
                return true;
            board[i][j]='.';
        }
        
        return false;        
        
    }
    
    
    private boolean isValid(char[][] board, int i, int j, char k){
        
        for(int r=0; r<9; r++){
            if(board[r][j]==k) return false;
            if(board[i][r]==k) return false;
        }
        
        i=i/3*3;
        j=j/3*3;
        
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                if(board[i+r][j+c]==k)
                    return false;
            }
        }
        
        
        return true;
        
    }
}