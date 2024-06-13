// https://leetcode.com/problems/word-search-ii

class Solution {
    
    List<String> res;
    boolean[][] seen;
    public List<String> findWords(char[][] board, String[] words) {
        
        int h = board.length;
        int w = board[0].length;
        
        seen = new boolean[h][w];
        
        res = new ArrayList<>();
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                
                char ch = board[i][j];
                for(String word : words){
                    if(word.charAt(0)==ch){
                        dfs(board, i, j, word, 0);
                        seen = new boolean[h][w];
                    }
                }
            }
        }
        
        res = new ArrayList<>(new HashSet<>(res));
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, String word, int idx){
        
        int h = board.length;
        int w = board[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        seen[i][j]=true;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        while(!queue.isEmpty()){
            
            if(idx==word.length()-1){
                res.add(word);
                return;
            }
            
            int siz = queue.size();
            
            for(int s=0; s<siz;s++){
               int[] p = queue.poll();
                

                for(int[] d : dirs){
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false && board[r][c]==word.charAt(idx+1)){
                        seen[r][c]=true;
                        queue.add(new int[]{r,c});
                    }
                } 
            }
            idx++;
        }
        
    }
}


/*
[["o","a","b","n"],
 ["o","t","a","e"],
 ["a","h","k","r"],
 ["a","f","l","v"]]
 
 ["oa","oa","oaa"]
 
 
 
 */



