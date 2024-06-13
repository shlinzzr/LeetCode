// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char ch = board[i][j];
                if(ch=='.') continue;
                if(set.add( "seen "+ ch + " at " + i + " row")==false
                 ||set.add( "seen "+ ch + " at " + j + " col")==false 
                 ||set.add( "seen "+ ch + " at " + (i/3*3) + "_" + (j/3*3) + " block")==false)
                    return false;
                
            }
        }
        // System.out.println(set);
        
        return true;
        
    }
}