// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {

        int n = board.length;

        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.') continue;

                set.add(board[i][j]+ " seen at " + i + " row");
                set.add(board[i][j]+ " seen at " + j + " col");
                set.add(board[i][j]+ " seen at " + i/3 + "_" + j/3 + " block");
            }
        }


        dfs(board, set, 0, 0);
        
    }

    private boolean dfs(char[][] board, Set<String> set, int row,  int col){

        if(row==9 ) return true;
        if(col==9) return dfs(board, set, row+1, 0);
        
        if(board[row][col]!='.') return dfs(board, set, row, col+1);

        for(char ch = '1'; ch<='9'; ch++){
            board[row][col] = ch;
            if(isValid(board, set, row, col)){

                set.add(board[row][col]+ " seen at " + row + " row");
                set.add(board[row][col]+ " seen at " + col + " col");
                set.add(board[row][col]+ " seen at " + row/3 + "_" + col/3 + " block");
                // System.out.println("board[" + row + "]["+ col+"]=" + ch);
                boolean rt = dfs(board, set, row, col+1);

                if(rt) return true;

                set.remove(board[row][col]+ " seen at " + row + " row");
                set.remove(board[row][col]+ " seen at " + col + " col");
                set.remove(board[row][col]+ " seen at " + row/3 + "_" + col/3 + " block");
            }
            board[row][col] = '.';
        }



        return false;


    }

    private boolean isValid(char[][] board, Set<String> set, int i, int j){
        if( set.contains(board[i][j]+ " seen at " + i + " row")) return false;
        if( set.contains(board[i][j]+ " seen at " + j + " col")) return false;
        if( set.contains(board[i][j]+ " seen at " + i/3 + "_" + j/3 + " block")) return false;

        return true;
    }

}