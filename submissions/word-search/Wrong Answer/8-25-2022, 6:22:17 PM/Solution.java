// https://leetcode.com/problems/word-search

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int h = board.length;
        int w = board[0].length;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(board[i][j]==word.charAt(0)){
                    boolean[][] bool = new boolean[h][w];
                    bool[i][j]=true;
                    
                    boolean res = dfs( board,word.substring(1, word.length()), new int[]{i, j}, bool);
                    if(res)
                        return true;
                }
            }
        }
        
        
        return false;
        
    }
    
    
    private boolean dfs(char[][] board, String word, int[] cur, boolean[][] bool){
        
        // for(boolean[] b : bool){
        //     System.out.print("[");
        //     for(boolean bb : b){
        //         System.out.print(bb + ", ");
        //     }
        //     System.out.print("],");
        // }
        //   System.out.println();
        
        
        if(word.length()==1)
            return true;
        
        // bool[cur[0]][cur[1]]=true;
        
        int h = bool.length;
        int w = bool[0].length;
        
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        boolean res = false;
        for(int[] d : dirs){
            
            int r = cur[0]+d[0];
            int c = cur[1]+d[1];
            
            if(r<0 || r>=h || c<0 || c>=w || bool[r][c]==true || board[r][c]!=word.charAt(0))
                continue;
            
            bool[r][c]=true;
            boolean recurRes = dfs(board, word.substring(1,word.length()), new int[]{r,c} , bool);
            bool[r][c]=false;
           
            res = res || recurRes;
        }
        
        // if(res==false)
        //     bool[cur[0]][cur[1]]=false;
        
        return res;
        
        
        
        
        
        // Stack<int[]> st = new Stack<>();
        // st.push(new int[]{i,j});
        
        // while(!st.isEmpty()){
        //     int[] cur = st.pop();
        // }
        
        
    }
}