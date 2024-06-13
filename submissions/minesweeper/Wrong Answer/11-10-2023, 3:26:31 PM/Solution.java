// https://leetcode.com/problems/minesweeper

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];

        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board ;
        }
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1}, {-1,0}};

        q.offer(click);
        seen[click[0]][click[1]]=true;
        board[click[0]][click[1]] = checkAdjMine(board, click);

        while(!q.isEmpty()){
            
            int siz = q.size();
            while(siz-->0){

                int[] p = q.poll();

                char cur = board[p[0]][p[1]];
                if(cur=='M'){
                    board[p[0]][p[1]]='X';
                    return board;
                }

                if(cur!='B')
                    continue;

                for(int[] d : dirs){
                    int r = d[0]+p[0];
                    int c = d[1]+p[1];
                    if(r<0 || c<0 || r>=m || c>=n || seen[r][c])
                        continue;
                    seen[r][c] = true;
                    char nxt = board[r][c];
                    if(nxt=='E'){
                        board[r][c] = checkAdjMine(board, new int[]{r,c});
                        if(board[r][c]=='B')
                            q.offer(new int[]{r,c});
                    }
                }
            }

          


        }
        return board;



    }

    private char checkAdjMine(char[][] board, int[] p){

        if(board[p[0]][p[1]]=='M')
            return 'X';

         int m = board.length;
        int n = board[0].length;
        int cnt= 0;

         int[][] dirs = new int[][]{{0,0},{0,1},{1,0},{0,-1}, {-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

        for(int[] d : dirs){

            int r=d[0]+p[0];
            int c=d[1]+p[1];
            if(r<0||c<0 ||r>=m || c>=n)
                continue;
            
            if(board[r][c]=='X' || board[r][c]=='M')
                cnt++;
        }
        return cnt==0 ? 'B' : (char) (cnt+'0');
    }
}

/*
input
[["E","E","E","E","E"]
,["E","E","M","E","E"]
,["E","E","E","E","E"]
,["E","E","E","E","E"]]

output
[["B","1","1","1","B"]
,["B","1","M","1","B"]
,["B","1","1","1","B"]
,["B","B","B","B","B"]]

expect
[["B","1","E","1","B"]
,["B","1","M","1","B"]
,["B","1","1","1","B"]
,["B","B","B","B","B"]]


*/