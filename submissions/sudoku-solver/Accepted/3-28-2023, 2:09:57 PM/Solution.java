// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        dfs(board, 0, 0);
        
    }
    
    
    private boolean dfs(char[][] board, int i, int j){
        if(i==9) return true;
        if(j==9) return dfs(board, i+1, 0);
        if(board[i][j]!='.')
            return dfs(board, i, j+1);
        
        for(char c='1'; c<='9'; c++){
            if(!isValid(board, i, j, c))
                continue;
            board[i][j]=c;
            if(dfs(board, i, j+1)==true)
                return true;
            board[i][j]='.';
        }
        
        return false;
        
        
    }
    
    
    private boolean isValid(char[][] board, int r, int c, char val){
        
        for(int i=0; i<9; i++){
            if(board[r][i]==val || (board[i][c]==val))
                return false;
        }
        
        // find block
        r=r/3*3;
        c=c/3*3;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                
                if(board[i+r][j+c]==val)
                    return false;
            }
        }
        
        return true;
    }
    
    
}