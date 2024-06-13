// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        
        for(int i=0; i<h; i++){
            // int[] arr = new int[h];
            HashSet<Character> set = new HashSet<>();
            
            
            for(int j=0; j<w; j++){
                // arr[board[i][j]-'0']++;
                if(board[i][j]=='.')
                    continue;
                
                if(!set.add(board[i][j]))
                    return false;
                
            }
            
            // for(int a : arr){
            //     if(a!=1)
            //         return false;
            // }
        }
        
        for(int j=0; j<w; j++){
            // int[] arr = new int[h];
            HashSet<Character> set = new HashSet<>();
            for(int i=0; i<h; i++){
                
                if(board[i][j]=='.')
                    continue;
                
                
                // arr[board[i][j]-'0']++;
                if(!set.add(board[i][j]))
                    return false;
            }
            
            // for(int a : arr){
            //     if(a!=1)
            //         return false;
            // }
        }
        
        
        int[][] dirs = {{0,0},{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        
        for(int i=1; i<h; i+=3){
            
            for(int j=1; j<w; j+=3){
                
                // int[] arr = new int[h];
                HashSet<Character> set = new HashSet<>();
                  if(board[i][j]=='.')
                    continue;
                
                
                for(int[] d : dirs){
                    // arr[board[i+d[0]][j+d[1]]-'0']++;
                    if(!set.add(board[i+d[0]][j+d[1]]))
                        return false;
                }
                
                
                // for(int a : arr){
                //     if(a!=1)
                //         return false;
                // }
                
            }
            
        }
        
        
        return true;
        
        
    }
}