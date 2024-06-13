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
    
    // private boolean dfs(char[][] board, int i, int j, int idx, String word, Set<String> set){
        
    //     int h = board.length;
    //     int w = board[0].length;
        
        
    //     if(i<0 || j<0 || i>=h || j>=w || set.contains(i+"_"+j))
    //         return false;
        
    //     if(idx==word.length()) return true;
        
    //     if(board[i][j]!=word.charAt(idx)) return false;
        
    //     if(i+1<h && board[i+1][j]==word.charAt(idx+1)){
            
    //         set.add((i+1)+ "_"+ j);
    //         dfs(board, i+1, j, idx+1, word, set);
    //         set.remove((i+1)+ "_"+ j);
    //     }
            
        
    //     if(j+1<w && board[i][j+1]==word.charAt(idx+1)){
            
    //         set.add(i+ "_"+(j+1));
    //         dfs(board, i, j+1, idx+1, word, set);
    //          set.remove(i+ "_"+(j+1));
    //     }
            
        
    //     if(i-1>=0 && board[i-1][j]==word.charAt(idx+1)){
    //         set.add((i-1)+ "_"+ j);
    //         dfs(board, i-1, j, idx+1, word, set);
    //         set.remove((i-1)+ "_"+ j);
    //     }
            
        
    //     if(j-1>=0 && board[i][j-1]==word.charAt(idx+1)){
            
    //         set.add(i+ "_"+(j-1));
    //         dfs(board, i, j-1, idx+1, word, set);
    //         set.remove(i+ "_"+(j-1));
    //     }
            
        
    //     return false;
        
}