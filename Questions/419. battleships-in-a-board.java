// https://leetcode.com/problems/battleships-in-a-board

class Solution {
    public int countBattleships(char[][] board) {
        
        int h = board.length;
        int w = board[0].length;
        
        int cnt=0;
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                
                if(board[i][j]=='X'){
                    dfs(board, i, j);
                    cnt++;
                }
            }
        }
        
        return cnt;
        
        
    }
    
    
    private void dfs(char[][] board, int i, int j){
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='.')
            return;
        
        board[i][j]='.';
        
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
        
        return;
        
        
    }
}