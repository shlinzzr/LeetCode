// https://leetcode.com/problems/word-search-ii

class Solution {
    
    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord;
        int cnt=0;
        String s;
        
        public TrieNode(){
            arr = new TrieNode[26];
            cnt=0;
        }
    }

    TrieNode root = new TrieNode();
    
    /*
[["o","a","a","n"]
,["e","t","a","e"]
,["i","h","k","r"]
,["i","f","l","v"]], 

words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

    */

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        int h = board.length;
        int w = board[0].length;
        
        buildTrie(words);

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char ch = board[i][j];
                if(root.arr[ch-'a']==null || root.arr[ch-'a'].cnt==0) continue;
                boolean[][] seen = new boolean[h][w];
                seen[i][j]=true;
                TrieNode curr = root;
                dfs(board, i, j, seen, res, curr.arr[ch-'a'], ""+ch);
            }
        }
        return res;
    }
    

      
    private void dfs(char[][] board, int i, int j, boolean[][] seen, List<String> res, TrieNode curr,String str){
        
        if(curr.isWord){
            res.add(curr.s);
            remove(curr.s);
        }
           
        int h = board.length;
        int w = board[0].length;

        for(int[] d: dirs){
            int r = i+d[0];
            int c = j+d[1];

            if(r<0 || c<0 || r>=h || c>=w || seen[r][c]) continue;
            char ch = board[r][c];
            
            if(curr.arr[ch-'a']==null || curr.arr[ch-'a'].cnt==0) continue;

            seen[r][c] =true;
            dfs(board, r, c, seen, res, curr.arr[ch-'a'], str+board[r][c]);
            seen[r][c] =false;
        }
    }
    

    private void buildTrie(String[] words){
        int len = words.length;

       
        for(String w : words){
            TrieNode curr = root;
            for(char ch : w.toCharArray()){
                if(curr.arr[ch-'a']==null ){
                    curr.arr[ch-'a'] = new TrieNode();   
                }
                curr.cnt++;
                curr= curr.arr[ch-'a'];
            }
            curr.cnt++;
            curr.s=w;
            curr.isWord = true;
        }

    }
      
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

    private void remove(String s){
        TrieNode curr = root;

        for(char ch : s.toCharArray()){

            curr.cnt--;
            curr = curr.arr[ch-'a'];
        } 
        curr.isWord =false;
    }
    
}