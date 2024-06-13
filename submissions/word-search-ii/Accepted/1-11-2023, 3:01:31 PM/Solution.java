// https://leetcode.com/problems/word-search-ii

class Solution {
    
    TrieNode root;
    
    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord;
        int count;

        public TrieNode(){
            arr = new TrieNode[26];
            isWord=false;
            count=0;
        }
    }
    
    
    public List<String> findWords(char[][] board, String[] words) {
        
        root = new TrieNode();
        for(String w : words){
            TrieNode node = root;
            for(char ch : w.toCharArray()){
                if(node.arr[ch-'a']==null)
                    node.arr[ch-'a']=new TrieNode();
                node.count++;
                node = node.arr[ch-'a'];
                
            }
            node.count++;
            node.isWord=true;
        }
        
        int h = board.length;
        int w = board[0].length;
        
        ArrayList<String>  res = new ArrayList<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                char ch = board[i][j];
                TrieNode node = root;
                if(node.arr[ch-'a']!=null && node.arr[ch-'a'].count>0){
                    boolean[][] seen = new boolean[h][w];
                    seen[i][j]=true;
                    dfs(board, new int[]{i,j}, seen, node.arr[ch-'a'], res, board[i][j]+"");
                }
                
            }
        }
        
        TrieNode node = root;
        for(int i=0; i<26; i++){
            TrieNode t = node.arr[i];
            if(t!=null){
                System.out.println( (char)(i+'a') + " " + t.count);
            }
        }
        
        res = new ArrayList<>(new HashSet<>(res));
        return res;
    }
    
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    private void dfs(char[][]board, int[] p, boolean[][] seen, TrieNode node, List<String> res, String curr){
        
        int h = board.length;
        int w = board[0].length;
        
        
        if(node.isWord==true){
            remove( curr);
            node.isWord=false;
            res.add(curr);
            // return;
        }
        
        
        for(int[] d: dirs){
            
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false){
                
                char ch = board[r][c];
                
                if(node.arr[ch-'a']!=null&&node.arr[ch-'a'].count>0){
                    TrieNode temp = node;
                    seen[r][c]=true;
                    dfs(board, new int[]{r,c}, seen, node.arr[ch-'a'], res, curr+board[r][c]);
                    seen[r][c]=false;
                }
            }
            
        }
        
        
    }
     private void remove( String s){
        
        TrieNode node = root;
        
        for(char c : s.toCharArray()){
            if(node.arr[c-'a']!=null){
                node=node.arr[c-'a'];
                node.count--;
            }
        }
    }
    
    
}