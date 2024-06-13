// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        for(int i=0; i<h; i++){
            
            Set<Character> set = new HashSet<>();
            
            for(int j=0; j<w; j++){
                
                if(board[i][j]!='.'){
                    
                    char c = board[i][j];
                    if(!set.contains(c))
                        set.add(c);
                    else return false;
                }
            }
        }
        
         for(int j=0; j<w; j++){
             
             Set<Character> set = new HashSet<>();
             
            for(int i=0; i<h; i++){
                 if(board[i][j]!='.'){
                    
                    char c = board[i][j];
                    if(!set.contains(c))
                        set.add(c);
                    else return false;
                }
            }
         }
        return true;
    }
    
    
}