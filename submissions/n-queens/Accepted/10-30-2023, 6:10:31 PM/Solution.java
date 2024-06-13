// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] mat = new char[n][n];
        for(char[] m : mat){
            Arrays.fill(m, '.');
        }
        

        helper(res, mat, 0, n);

        return res;
    }

    private void helper(List<List<String>>res , char[][] mat , int i, int n){
        if(i==n){
            List<String> list = new ArrayList<>();
            for(char[] m : mat){
                list.add(new String(m));
            }
            
            res.add(list);
            return;
        }

        for(int j=0; j<n; j++){

            if(isValid(mat, i, j)){
                mat[i][j] = 'Q';
                helper(res, mat, i+1, n);
                mat[i][j]= '.';
            }
        }
    }

    private boolean isValid(char[][] mat, int r, int c ){

        // check vertical
        for(int i=0; i<r; i++){
            if(mat[i][c]=='Q')
                return false;
        }

        //check horizontal
        for(int j=0; j<c; j++){
            if(mat[r][j]=='Q')
                return false;
        }

        int k=1;
        // check top-left
        while(r-k>=0 && c-k>=0){
            if(mat[r-k][c-k]=='Q')
                return false;
            k++;
        }

        //check top-right
        k=1;
        while(r-k>=0 && c+k<mat.length){
            if(mat[r-k][c+k]=='Q')
                return false;
            k++;
        }

        return true;



    }
}