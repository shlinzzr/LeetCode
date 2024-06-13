// https://leetcode.com/problems/game-of-life

class Solution {
    int die = 2;
    int live = 3;
    
    public void gameOfLife(int[][] board) {
        int h = board.length;
        int w = board[0].length;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                int cnt = cntNeb(board, j, i, h, w);
                
                if(board[i][j]==1){
                    if(cnt<2 || cnt>3 )
                        board[i][j]=die;    
                }else{
                    if(cnt==3){
                        board[i][j]=live;
                    }
                }
            }
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(board[i][j]==die)
                    board[i][j]=0;
                else if(board[i][j]==live)
                    board[i][j]=1;
            }
        }
        
        return;
        
        
        
    }
    
    
    private int cntNeb(int[][] board, int x, int y, int h, int w){
        int cnt =0;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {-1,-1}, {-1,1}, {1,-1}};
        for(int[] d : dirs){
            
            int r = y+d[0];
            int c = x+d[1];
            if(r<0 || r>=h || c<0 || c>=w)
                continue;
            
            if(board[r][c]==1 || board[r][c]==die){
                cnt++;
            }
        }
        
        return cnt;
    }
}