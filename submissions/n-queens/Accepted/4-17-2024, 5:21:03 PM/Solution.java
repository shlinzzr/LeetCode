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
        if(r==arr.length){
            List<String> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                list.add(new String(arr[i]));
            }
            res.add(list);
            return;
        }

        for(int j=0; j<arr.length; j++){
            if(isValid(arr, r, j)){
                arr[r][j] = 'Q';
                // System.out.println();
                // for(int k=0; k<arr.length; k++){
                //     System.out.println(new String(arr[k]));
                // }
                dfs(arr, r+1, res);
                arr[r][j] = '.';   
            }
        }
    }

    private boolean isValid(char[][] arr, int r, int c){
        int n = arr.length;
        for(int i=0; i<r; i++){
            if(arr[i][c]=='Q') return false;
        }   

        // check top-left
        for(int i=r-1, j=c-1; i>=0&&j>=0; i--, j--){
            if(arr[i][j]=='Q') return false;   
        }

        // check top-right
        for(int i=r-1,j=c+1; i>=0&&j<n; i--,j++){
            if(arr[i][j]=='Q') return false;
        }

        return true;


    }

}