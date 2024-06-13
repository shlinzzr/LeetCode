// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
        return;
    }
    
//       public boolean solve(char[][] board){
//         for(int i = 0; i < board.length; i++){
//             for(int j = 0; j < board[0].length; j++){
//                 if(board[i][j] == '.'){
//                     for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
//                         if(isValid(board, j, i, c)){
//                             board[i][j] = c; //Put c for this cell
                            
//                             if(solve(board))
//                                 return true; //If it's the solution return true
//                             else
//                                 board[i][j] = '.'; //Otherwise go back
//                         }
//                     }
                    
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
    
    
    private boolean helper(char[][] board){
        
        int h=board.length;
        int w=board[0].length;
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                
                if(board[i][j]=='.'){
                    for(char c='1'; c<='9'; c++){

                        if(isValid(board, j, i, c)){
                            board[i][j]=c;
                            if(helper(board)){
                               return true;
                            }else{
                                board[i][j] = '.';    
                            }    
                        }
                        
                    }
                    
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
    
    private boolean isValid(char[][] board, int col, int row, char c){
        
        for(int i=0; i<9; i++){
            
            if( board[i][col]==c) return false;
            if( board[row][i]==c) return false;
            if( board[3*(row/3) + i/3][3*(col/3) + i%3]==c) return false;
        }
        
        return true;
        
    }



}