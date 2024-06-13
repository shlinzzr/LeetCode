// https://leetcode.com/problems/surrounded-regions

class Solution {
    public void solve(char[][] board) {
        int h= board.length;
        int w= board[0].length;

        boolean[][] seen = new boolean[h][w];

        Queue<int[]> q= new LinkedList<>();
        for(int i=0; i<h; i++){
            
            if(board[i][0]=='O'){
                q.offer(new int[]{i, 0});
                seen[i][0] = true;
            }

            if(board[i][w-1]=='O'){
                q.offer(new int[]{i, w-1});
                seen[i][w-1] = true;
            }
        }

        for(int j=0; j<w; j++){
            if(board[0][j]=='O'){
                q.offer(new int[]{0, j});
                seen[0][j]=true;
            }
            if(board[h-1][j]=='O'){
                q.offer(new int[]{h-1, j});
                seen[h-1][j]=true;
            }
        }

        int[][] dirs = new int[][]{{0,1},{1,0}, {0,-1}, {-1,0}};
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int[] d: dirs){
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || board[r][c]=='X')
                    continue;
                q.offer(new int[]{r,c});
                seen[r][c]=true;
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j]=='O' && seen[i][j]==false){
                    board[i][j] = 'X';
                }
            }
        }

    }


}