// https://leetcode.com/problems/word-search

class Solution {
    
     int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
    
    public boolean exist(char[][] board, String word) {
        int h= board.length;
        int w = board[0].length;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited = new boolean[h][w];
                    visited[i][j]=true;
                    boolean res = dfs(board, word, 0, new int[]{i,j}, visited);
                    if(res)
                        return true;    
                }
                
                
            }
        }
        
        return false;
        
    }
    
    private boolean dfs(char[][] board, String word, int idx, int[] p,  boolean[][] visited){
        
        int h= board.length;
        int w = board[0].length;
        
        if(idx+1==word.length()){
            return true;
        }
            
        
        boolean res = false;
        
        for(int[] d : dirs){

            int r = p[0]+d[0];
            int c = p[1]+d[1];
            if(r>=0 && c>=0 && r<h && c<w && visited[r][c]==false && word.charAt(idx+1)==board[r][c]){
                visited[r][c] = true;
                res = res || dfs(board, word, idx+1, new int[]{r,c}, visited);
                visited[r][c]=false;
                
            }
        }
        
        return res;
            
            
            
            
        
        
        
    }
}