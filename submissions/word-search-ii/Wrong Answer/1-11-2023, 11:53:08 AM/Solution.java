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
            count=1;
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
            node.isWord=true;
        }
        
        int h = board.length;
        int w = board[0].length;
        
        ArrayList<String>  res = new ArrayList<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                char ch = board[i][j];
                if(root.arr[ch-'a']!=null){
                    boolean[][] seen = new boolean[h][w];
                    seen[i][j]=true;
                    dfs(board, new int[]{i,j}, seen, root, res, "");
                }
                
            }
        }
        
        res = new ArrayList<>(new HashSet<>(res));
        return res;
    }
    
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    private void dfs(char[][]board, int[] p, boolean[][] seen, TrieNode node, List<String> res, String curr){
        
        int h = board.length;
        int w = board[0].length;
        
        if(node.isWord){
            res.add(curr);
        }
        
        for(int[] d: dirs){
            
            int r = p[0]+d[0];
            int c = p[1]+d[1];
            
            if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false){
                
                char ch = board[r][c];
                if(node.arr[ch-'a']!=null){
                    TrieNode temp = node.arr[ch-'a'];
                    seen[r][c]=true;
                    dfs(board, new int[]{r,c}, seen, temp, res, curr+ch);
                    seen[r][c]=false;
                }
            }
            
        }
        
    }
    
}