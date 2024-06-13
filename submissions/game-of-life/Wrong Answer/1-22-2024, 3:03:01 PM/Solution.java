// https://leetcode.com/problems/game-of-life

class Solution {
    public void gameOfLife(int[][] board) {
        
        int h = board.length;
        int w = board[0].length;
        
        // <2 : 0
        // 2,3 : remain 1
        // >3 : 0
        // 3 : become 1
        
        int[][] res = board.clone();
       
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                int live =0;
                for(int r=i-1; r<i+2 && r<h; r++){
                    if(r<0) continue;
                    for(int c=j-1; c<w && c<j+2; c++){
                        if(c<0 || (r==i && c==j)) continue;
                        
                        live += (board[r][c]==1 ? 1 : 0);
                    }
                }
                
                if(board[i][j]==1){
                    if(live<2 || live>3) res[i][j]=0;
                    
                }else{
                    if(live==3) res[i][j]=1;
                    
                }
            }
        }
        
        board = res;
        
        
        
        
        
        
        
        
    }
}