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
        // System.out.println("row pass");
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
        
        // System.out.println("col pass");
        
        for(int i=0; i<h/3; i++){
            for(int j=0; j<w/3; j++){
                Set<Character> set= new HashSet<>();
                for(int r=0; r<3; r++){
                    
                    for(int c=0; c<3; c++){
                        
                        char ch = board[i*3+r][j*3+c];
                        if(ch!='.'){
                            if(!set.contains(ch))
                                set.add(ch);
                            else {
//                                 System.out.println(i);
//                                 System.out.println(j);
//                                 System.out.println(r);
//                                 System.out.println(c);
//                                 System.out.println(ch);
                                return false;
                            }
                        }
                        
                            
                    }
                }
            }
        }
        
        System.out.println("mat pass");
        
        /*
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]*/


        
        
        return true;
    }
    
    
}