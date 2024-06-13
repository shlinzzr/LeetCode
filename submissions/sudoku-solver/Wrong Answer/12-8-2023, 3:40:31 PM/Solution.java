// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;

        Set<String> seen = new HashSet<>();

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(board[i][j]=='.'){
                    for(char k='1'; k<='9'; k++){

                        if( !seen.contains( board[i][j] + " exists at row:" + i)
                         && !seen.contains(board[i][j] + " exists at col:" + j)
                         && !seen.add(board[i][j] + " exists at block:" + (i/3*3+i%3) + "_"+ (j/3*3+j%3))){
                            board[i][j] = k;

                            seen.add(board[i][j] + " exists at row:" + i);
                            seen.add(board[i][j] + " exists at col:" + j);
                            seen.add(board[i][j] + " exists at block:" + (i/3*3+i%3) + "_"+ (j/3*3+j%3));
                         }

                    }
                    


                }else{
                    seen.add(board[i][j] + " exists at row:" + i);
                    seen.add(board[i][j] + " exists at col:" + j);
                    seen.add(board[i][j] + " exists at block:" + (i/3*3+i%3) + "_"+ (j/3*3+j%3));
                }

            }
        }


    }
}