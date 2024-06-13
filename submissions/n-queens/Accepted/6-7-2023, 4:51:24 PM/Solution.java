// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        char[][] mat = new char[n][n];
        for(char[] arr : mat)
            Arrays.fill(arr, '.');
        
        helper(res, mat, n, 0);
        
        return res;
        
    }
    
    
    private void helper(List<List<String>> res, char[][] mat, int n, int i){
        
        if(i==n){
            List<String> list =new ArrayList<>();
            for(char[] r: mat){
                list.add(new String(r));
            }
            res.add(list);
            return;
        }
        
        
        for(int j=0; j<n; j++){
            if(isValid(mat, i, j)==true) {
                mat[i][j] = 'Q';
                helper(res, mat, n, i+1);
                mat[i][j] = '.';
            }
        }
        
    }
    
     private boolean isValid(char[][] board, int r, int c){
        
         int len = board.length;
         
         // check vertical
        for(int i=0; i<r; i++){
            if(board[i][c]=='Q') return false;
        }
        
         // check horizontal
        for(int j=0; j<c; j++){
            if(board[r][j]=='Q')return false;
        }
         
         //check top left
        int k=1;
        while(r-k>=0 && c-k>=0){
            if(board[r-k][c-k]=='Q') return false;
            k++;
        }
         
         // check top right
        k=1;
        while(r-k>=0 && c+k<len){
            if(board[r-k][c+k]=='Q') return false;
            k++;
        }
        
        return true;
    }
    
    /*[[".Q..","Q...","..Q.","...Q"],
       [".Q..","Q...","...Q","..Q."],
       [".Q..","..Q.","Q...","...Q"],
       [".Q..","..Q.","...Q","Q..."],
       [".Q..","...Q","Q...","..Q."],
       
       [".Q..","...Q","..Q.","Q..."],
       ["..Q.","Q...",".Q..","...Q"],
       ["..Q.","Q...","...Q",".Q.."],
       ["..Q.",".Q..","Q...","...Q"],
       ["..Q.",".Q..","...Q","Q..."],
       
       ["..Q.","...Q","Q...",".Q.."],
       ["..Q.","...Q",".Q..","Q..."],
       ["...Q","Q...",".Q..","..Q."],
       ["...Q","Q...","..Q.",".Q.."],
       ["...Q",".Q..","Q...","..Q."],
       
       ["...Q",".Q..","..Q.","Q..."],
       ["...Q","..Q.","Q...",".Q.."],
       ["...Q","..Q.",".Q..","Q..."]]
*/
    
}