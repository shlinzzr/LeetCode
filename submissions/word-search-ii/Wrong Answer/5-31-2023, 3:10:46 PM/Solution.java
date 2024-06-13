// https://leetcode.com/problems/word-search-ii

class Solution {
    
    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord;
        int cnt=0;
        
        public TrieNode(){
            arr = new TrieNode[26];
            cnt=0;
        }
    }
    TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        int h = board.length;
        int w = board[0].length;
        
        for(String wd: words){
            
            TrieNode curr = root;
            for(int i=0; i<wd.length();i++){

                char ch = wd.charAt(i);
                
                if(curr.arr[ch-'a']==null){
                    curr.arr[ch-'a'] = new TrieNode();
                }
                curr.cnt++;
                curr = curr.arr[ch-'a'];
            }
            curr.cnt++;
            curr.isWord=true;
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char ch = board[i][j];
                boolean[][] seen = new boolean[h][w];
                if(root.arr[ch-'a']!=null){
                    dfs(board, new int[]{i, j}, root.arr[ch-'a'], res, ""+board[i][j], seen);
                }
            }
        }
        
        return res;
        
    }
    
      
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    
    private void dfs(char[][] board, int[] p, TrieNode node, List<String> res, String curr, boolean[][] seen){

        if(node.isWord){
            remove(curr);
            res.add(curr);
            node.isWord=false;
        }
        
           
        int h = board.length;
        int w = board[0].length;
        
        
        for(int[] d: dirs){
            
            int r = d[0]+p[0];
            int c = d[1]+p[1];
            
            if(r<0 || c<0 || r>=h || c>=w || seen[r][c])
                continue;
            
            char ch = board[r][c];
            if(node.arr[ch-'a']!=null && node.arr[ch-'a'].cnt>0){
                seen[r][c] =true;
                dfs(board, new int[]{r,c}, node.arr[ch-'a'], res, curr + ch, seen);
                seen[r][c] = false;
            }
            
        }
        
    }
    
    
    private void remove(String s){
        TrieNode node = root;
        for(char ch: s.toCharArray()){
            if(node.arr[ch-'a']!=null){
                node.arr[ch-'a'].cnt--;
                node=node.arr[ch-'a'];
                
            }
            
        }
        node.isWord=false;
    
    }
}