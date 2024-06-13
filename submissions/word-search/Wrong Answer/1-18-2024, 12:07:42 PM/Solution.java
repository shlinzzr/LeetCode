// https://leetcode.com/problems/word-search

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int h = board.length;
        int w = board[0].length;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j]==word.charAt(0)){
                    
                    if (dfs(board, i , j, 0, word, new HashSet<>()) )
                        return true;
                }
            }
        }
        
        return false;
        
        
    }
    
    private boolean dfs(char[][] board, int i, int j, int idx, String word, Set<String> set){
        
        int h = board.length;
        int w = board[0].length;
        
        
        if(i<0 || j<0 || i>=h || j>=w || set.contains(i+"_"+j))
            return false;
        
        if(idx==word.length()) return true;
        
        if(board[i][j]!=word.charAt(idx)) return false;
        
        if(i+1<h && board[i+1][j]==word.charAt(idx+1)){
            
            set.add((i+1)+ "_"+ j);
            dfs(board, i+1, j, idx+1, word, set);
            set.remove((i+1)+ "_"+ j);
        }
            
        
        if(j+1<w && board[i][j+1]==word.charAt(idx+1)){
            
            set.add(i+ "_"+(j+1));
            dfs(board, i, j+1, idx+1, word, set);
             set.remove(i+ "_"+(j+1));
        }
            
        
        if(i-1>=0 && board[i-1][j]==word.charAt(idx+1)){
            set.add((i-1)+ "_"+ j);
            dfs(board, i-1, j, idx+1, word, set);
            set.remove((i-1)+ "_"+ j);
        }
            
        
        if(j-1>=0 && board[i][j-1]==word.charAt(idx+1)){
            
            set.add(i+ "_"+(j-1));
            dfs(board, i, j-1, idx+1, word, set);
            set.remove(i+ "_"+(j-1));
        }
            
        
        return false;
        
    }
}