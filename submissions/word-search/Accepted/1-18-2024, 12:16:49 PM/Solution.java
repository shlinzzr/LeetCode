// https://leetcode.com/problems/word-search

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int h = board.length;
        int w = board[0].length;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j]==word.charAt(0)){
                    
                    if (dfs(board, word, 0, i , j, new boolean[h][w]) )
                        return true;
                }
            }
        }
        
        return false;
        
        
    }

     int[][]dirs = new int[][]{{0,1},{0,-1}, {1,0},{-1,0}};
    private boolean dfs(char[][]board, String word, int idx, int i, int j, boolean[][] seen){
        
        // System.out.println(word.charAt(idx) + " i=" + i + " j=" + j);
        
          int h = board.length;
        int w = board[0].length;
        
        if(idx==word.length()-1){
            return true;
        }
        seen[i][j]=true;
        
        for(int[] d: dirs){
            int r = i+d[0];
            int c = j+d[1];
            
            if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || board[r][c]!=word.charAt(idx+1))
                continue;
            
            seen[r][c] = true;
            
            boolean res = dfs(board, word, idx+1, r, c, seen);
            if(res)
                return true;
            
            seen[r][c]=false;
        }
        
        return false;
    }
    
        
}