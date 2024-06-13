// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        for(int i=0; i<h; i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<w; j++){
                if(board[i][j]!='.' && set.contains(board[i][j])){
                    // System.out.println(1);
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        
        
        
        for(int j=0; j<w; j++){
            Set<Character> set = new HashSet<>();
            for(int i=0; i<h; i++){ 
                if(board[i][j]!='.' && set.contains(board[i][j])){
                    System.out.println(2);
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        
        
        for(int i=0; i<h/3; i++){
            
            for(int j=0; j<w/3; j++){
                Set<Character> set = new HashSet<>();
                
                for(int k=0; k<h/3; k++){
                    for(int l=0; l<w/3; l++){
                        if(board[3*i+k][3*j+l]!='.' && set.contains(board[3*i+k][3*j+l])){
                            System.out.println(3);
                            return false;
                        }
                        set.add(board[3*i+k][3*j+l]);
                    }
                }
                
            }
        }
        Set<Character> set = new HashSet<>();
        for(int i=0; i<h; i++){
            if(board[i][i]!='.' && set.contains(board[i][i])){
                    System.out.println(4);
                    return false;
            }
        }
        
        set = new HashSet<>();
        for(int i=0; i<h; i++){
            if(board[i][w-i-1]!='.' && set.contains(board[i][w-i-1])){
                System.out.println(5);
                return false;
            }
        }
        
        
        return true;
    
    }
}