// https://leetcode.com/problems/n-queens

class Solution {
    
    List<List<String>> res;
    int len=0;
    char[][] board;
    
    
    public List<List<String>> solveNQueens(int n) {
        
        res = new ArrayList<>();
        len =n;
        board = new char[n][n];
        for(char[] b: board){
            Arrays.fill(b, '.');    
        }
        
        dfs(0);
        
        
        return res;
    }
    
    private void dfs(int i){
        
        if(i==len){
            res.add(construct(board));
            return;
        }
        
        for(int j=0; j<len; j++){
            
            if(isValid(i, j)){
                board[i][j]='Q';
                dfs(i+1);
                board[i][j]='.';
            }
            
        }
        
    }
    
    
    private boolean isValid(int r, int c){
        
        for(int i=0; i<r; i++){
            if(board[i][c]=='Q') return false;
        }
        
        for(int j=0; j<c; j++){
            if(board[r][j]=='Q')return false;
        }
        
        int k=1;
        while(r-k>=0 && c-k>=0){
            if(board[r-k][c-k]=='Q') return false;
            k++;
        }
        k=1;
        while(r-k>=0 && c+k<len){
            if(board[r-k][c+k]=='Q') return false;
            k++;
        }
        
        return true;
    }
    
    
    private List<String> construct(char[][] board) {
        List<String> list = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }
}