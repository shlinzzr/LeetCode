// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(arr[i], '.');
        }


        dfs(arr, 0, res);

        return res;
    } 

    private void dfs(char[][] arr, int r, List<List<String>> res){
        int n = arr.length;

        if(r==n){
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                String s = new String(arr[i]);
                list.add(s);
            }
            res.add(list);
            return;
        }

        for(int j=0; j<n; j++){
            if(isValid(arr, r, j)){
                arr[r][j] = 'Q';
                dfs(arr, r+1, res);
                arr[r][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] arr, int r, int c){

        int n = arr.length;
        for(int k=0; k<n; k++){
            if(arr[r][k]=='Q') return false;
            if(arr[k][c]=='Q') return false;
        }

        for(int i=r, j=c; i<n&&j<n; i++,j++){
            if(arr[i][j]=='Q') return false;
        }

        for(int i=r, j=c; i>=0&&j>=0; i--,j--){
            if(arr[i][j]=='Q') return false;
        }

        for(int i=r, j=c; i>=0&&j<n; i--,j++){
            if(arr[i][j]=='Q') return false;
        }
        for(int i=r, j=c; i<n&&j>=0; i++,j--){
            if(arr[i][j]=='Q') return false;
        }
        return true;

    }
}