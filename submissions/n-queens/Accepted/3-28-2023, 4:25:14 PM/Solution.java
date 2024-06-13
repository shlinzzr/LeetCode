// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        char[][] mat = new char[n][n];
        for(char[] arr : mat)
            Arrays.fill(arr, '.');
        
        boolean[] row= new boolean[n];
        boolean[] col = new boolean[n];
        
        helper(res, mat, n, row, col, 0);
        
        return res;
        
    }
    
    
    private void helper(List<List<String>> res, char[][] mat, int n, boolean[] row, boolean[] col, int i){
        
        if(i==n){
            List<String> list =new ArrayList<>();
            for(char[] r: mat){
                list.add(new String(r));
            }
            
            res.add(list);
            return;
        }
        
        
        for(int j=0; j<n; j++){
            if(row[i]==false && col[j]==false && isValid(mat, i, j)==true) {
                mat[i][j] = 'Q';
                helper(res, mat, n, row, col, i+1);

                mat[i][j] = '.';
            }
        }
        
    }
    
    
//     private boolean nonUsedDia(char[][] mat, int i, int j){
//         int len = mat.length;
        
        
//         for(int k=0; k<=len && i+k<len && j+k<len; k++){
//             if(mat[i+k][j+k]!='.')
//                 return false;
//         }
        
//         for(int k=0; k<=len && i-k>=0 && j-k>=0; k++){
//             if(mat[i-k][j-k]!='.')
//                 return false;
//         }
        
//         for(int k=0; k<=len && i+k<len && j-k>=0; k++){
//             if(mat[i+k][j-k]!='.')
//                 return false;
//         }
        
//         for(int k=0; k<=len && i-k>=0 && j+k<len; k++){
//             if(mat[i-k][j+k]!='.')
//                 return false;
//         }
        
//         return true;
        
//     }
    
    
     private boolean isValid(char[][] board, int r, int c){
        
         int len = board.length;
         
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