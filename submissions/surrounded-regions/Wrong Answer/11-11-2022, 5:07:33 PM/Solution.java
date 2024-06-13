// https://leetcode.com/problems/surrounded-regions

class Solution {
    public void solve(char[][] board) {
        int h= board.length;
        int w = board[0].length;

        boolean[][] act = new boolean[h][w];
        
        for(int i=0; i<h; i++){
            if(board[i][0]=='X'){
                act[i][0]=true;
            }else{
                dfs(board, act, new int[]{i,0});
            }
            
            if(board[i][w-1]=='X'){
                act[i][w-1]=true;
            }else{
                dfs(board, act, new int[]{i, w-1});
            }
        }
        
        for(int j=0; j<w; j++){
            if(board[0][j]=='X'){
                act[0][j]=true;
            }else{
                dfs(board, act, new int[]{0,j});
            }
            
            if(board[h-1][j]=='X'){
                act[h-1][j]=true;
            }else{
                dfs(board, act, new int[]{h-1, j});
            }
        }
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(act[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
        
        
        
    }
    
    int[][] dirs = new int[][]{{0,1} ,{0,-1}, {1,0}, {-1, 0}};
    
    private void dfs(char[][] board, boolean[][] act, int[] p){
        
        int h= board.length;
        int w = board[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(p);
        act[p[0]][p[1]]=true;
        
        
        while(!q.isEmpty()){
            p = q.poll();
            
            for(int[] d : dirs){
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                if(r<0 || c<0 || r>=h || c>=w || act[r][c]==true || board[r][c]=='X')
                    continue;

                act[r][c]=true;
            }
        }
        
    }
}