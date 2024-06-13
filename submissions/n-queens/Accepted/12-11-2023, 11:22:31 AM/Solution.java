// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        helper(n ,res , new ArrayList<>(), 0);
        return res;
    }

    private void helper(int n, List<List<String>> res, List<String> curr, int i){

        if(i==n){
            res.add(new ArrayList<>(curr));
            return;
        }

        char[] row = new char[n];
        Arrays.fill(row, '.');


        for(int j=0; j<n; j++){
            row[j] = 'Q';
            if(isValid(n, curr, i, j)){
                curr.add(new String(row));
                helper(n, res, curr, i+1);
                curr.remove(curr.size()-1);
            }

            row[j]='.';
        }

    }

    private boolean isValid(int n, List<String> curr, int r, int c){

        // // check left, 
        // String s = curr.get(r);
        // for(int j=0; j<s.length(); j++){
        //     if(s.charAt(j)=='Q')
        //         return false;
        // }

        // check up.

        for(int i=0; i<curr.size(); i++){
            String s = curr.get(i);
            if(s.charAt(c)=='Q')
                return false;
        }

        // check left up,
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            char ch = curr.get(i).charAt(j);
            if(ch=='Q') return false;
        }

        // check right up
        for(int i=r-1, j=c+1; i>=0 && j<n; i--, j++){
            char ch = curr.get(i).charAt(j);
            if(ch=='Q') return false;
        }

        return true;

    }
}