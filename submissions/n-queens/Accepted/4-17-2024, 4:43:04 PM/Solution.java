// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] arr = new char[n][n];

        boolean[] rowUsed = new boolean[n];
        boolean[] colUsed = new boolean[n];
        for(int i=0; i<n; i++){
            Arrays.fill(arr[i], '.');
        }

        dfs(arr, res, n, rowUsed, colUsed);

        return res;
    }

    private void dfs(char[][] arr, List<List<String>> res, int n, boolean[] rowUsed, boolean[] colUsed){
        if(n==0){
            List<String> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                list.add(new String(arr[i]));
            }
            res.add(list);
            return;
        }


        for(int i=0; i<arr.length; i++){
            if(rowUsed[i]) continue;
            
            for(int j=0; j<n; j++){
                if(colUsed[j]) continue;

                if(!isValid(arr, i, j)) continue;
                
                rowUsed[i] = true;
                colUsed[j] = true;

                arr[i][j] = 'Q';
                dfs(arr, res, n-1, rowUsed, colUsed);
                arr[i][j] = '.';
                rowUsed[i] = false;
                colUsed[j] = false;

            }
            
        }
    }

     /*

     [
        ["...Q"
        ,"Q..."
        ,"..Q."
        ,".Q.."]

       [[".Q.."
        ,"...Q"
        ,"Q..."
        ,"..Q."],

        ["Q..."
        ,"...Q"
        ,".Q.."
        ,"..Q."]
     */   





    private boolean isValid(char[][] arr, int r, int c){
        int n = arr.length;
        // // // check left, 
        // String s = curr.get(r);
        // for(int j=0; j<s.length(); j++){
        //     if(s.charAt(j)=='Q')
        //         return false;
        // }

        // // check up.

        // for(int i=0; i<curr.size(); i++){
        //     String s = new String(arr[i])
        //     if(s.charAt(c)=='Q')
        //         return false;
        // }

        // check left up,
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            char ch = arr[i][j];
            if(ch=='Q') return false;
        }

        // check right up
        for(int i=r-1, j=c+1; i>=0 && j<n; i--, j++){
            char ch = arr[i][j];
            if(ch=='Q') return false;
        }

         // check left down,
        for(int i=r+1, j=c+1; i<n && j<n; i++, j++){
            char ch = arr[i][j];
            if(ch=='Q') return false;
        }

        // check right down,
        for(int i=r+1, j=c-1; i<n && j>=0; i++, j--){
            char ch = arr[i][j];
            if(ch=='Q') return false;
        }

        return true;

    }
}