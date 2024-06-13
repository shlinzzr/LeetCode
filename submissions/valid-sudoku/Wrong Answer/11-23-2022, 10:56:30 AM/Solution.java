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
        
        for(int i=0; i<h/3; i++){
            
            for(int j=0; j<w/3; j++){
                
                Set<Character> set= new HashSet<>();
                for(int r=0; r<3; r++){
                    
                    for(int c=0; c<3; c++){
                        
                        char ch = board[i*3+r][j*3+c];
                        
                        if(!set.contains(ch))
                            set.add(ch);
                        else return false;
                    }
                    
                }
                
                
                
                
            }
            
        }
        
        
        
        
        return true;
    }
    
    
}