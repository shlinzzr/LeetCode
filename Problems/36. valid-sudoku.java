// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                char n = board[i][j];
                if(n!='.'){
                    if( !set.add( n + " in row " + i)
                     || !set.add( n + " in col " + j)
                     || !set.add( n + " in block " + (i/3) + " "+ (j/3)))
                        return false;
                }
            }
        }
        
        return true;
    
    }
}