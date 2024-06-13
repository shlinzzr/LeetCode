// https://leetcode.com/problems/sudoku-solver

class Solution {
    
     boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
    
    public void solveSudoku(char[][] board) {
        
       
        
        int h=board.length;
        int w=board[0].length;
        
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                
                if(board[i][j]!='.'){
                    int num = board[i][j]-'1';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i/3*3+j/3][num]=true;
                    
                    
//                     for(char c='1'; c<='9'; c++){

//                         if(isValid(board, j, i, c)){
//                             board[i][j]=c;
//                             if(helper(board)){
//                                return true;
//                             }else{
//                                 board[i][j] = '.';    
//                             }    
//                         }
                        
//                     }
                    
//                     return false;
                }
            }
            
        }
        
        backtracking(board, 0, 0);
        
    }
    
     public boolean backtracking(char[][] board, int r, int c)
    {
        int i,j;
        for(i=r;i<9;i++)
        {
            if(i==r) j=c;else j=0;
            for(;j<9;j++)
            {
                if(board[i][j]!='.') 
                    continue;
                for(int k=0;k<9;k++)
                {
                    if(legal(i,j,k)) 
                    {
                        char pre = board[i][j];
                        row[i][k] = true;
                        col[j][k] = true;
                        box[i/3*3+j/3][k] = true;
                        board[i][j] = (char)(k+49);
                        if(j==8 && backtracking(board,r+1,0)) return true;
                        if(j!=8 && backtracking(board,r,c+1)) return true;
                        row[i][k] = false;
                        col[j][k] = false;
                        box[i/3*3+j/3][k] = false;
                        board[i][j]=pre;
                    }
                }
                return false;
            }
        }
        return true;
    }
    
     public boolean legal(int i,int j, int num)
    {
        if(!row[i][num] && !col[j][num] && !box[i/3*3+j/3][num]) return true;
        else return false;
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