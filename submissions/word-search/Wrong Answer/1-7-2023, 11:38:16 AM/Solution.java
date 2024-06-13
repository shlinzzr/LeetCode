// https://leetcode.com/problems/word-search

class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board.length;
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(board[i][j]==word.charAt(0)){
                    boolean[][] seen = new boolean[h][w];
                    seen[i][j]=true;
                    boolean res = dfs(board, new int[]{i,j}, word, 0, seen);
                    if(res) 
                        return true;
                }
                
            }
        }
        
        return false;
        
    }
    
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    private boolean dfs(char[][]board, int[] p, String word, int idx, boolean[][] seen){
        
        if(idx+1==word.length())
            return true;
        
        
        int h = board.length;
        int w = board.length;
        
        for(int d[] : dirs){
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            
            
            if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false){
                
                if(word.charAt(idx+1)==board[r][c]){
                    seen[r][c]=true;
                    boolean res = dfs(board, new int[]{r,c}, word, idx+1, seen);
                    if(res)
                        return res;
                    seen[r][c]=false;
                }
                
            }
        }
        return false;
        
    }
}