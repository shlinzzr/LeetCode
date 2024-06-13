// https://leetcode.com/problems/word-search-ii

class Solution {
    
    class TrieNode{
        TrieNode[] arr;
        boolean isWord=false;
        String str="";
        int cnt = 0;
        
        public TrieNode(){
            arr =  new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Set<String> res = new HashSet<>();
        
        Set<String> set = new HashSet<>(Arrays.asList(words));
        
        int h = board.length;
        int w = board[0].length;
        
        buildTrie(words);

        // System.out.println(root.arr[0].arr[0].isWord+ " " +root.arr[0].arr[0].str);
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char ch = board[i][j];
                if(root.arr[ch-'a']!=null && root.arr[ch-'a'].cnt>0){
                    TrieNode curr = root.arr[ch-'a'];
                    Set<String> seen = new HashSet<>();
                    seen.add(i+"_"+j);
                    helper(curr, seen, i, j, res, board);

                    if(curr.isWord){
                        res.add(curr.str);
                    }
                }
            }
        }
        
        return new ArrayList(res);
        
    }
    
    
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0},{0,-1}};
    private void helper(TrieNode curr, Set<String> seen, int i, int j, Set<String> res, char[][]board){
            
        int h = board.length;
        int w = board[0].length;
        
        for(int[]d : dirs){
            int r = i+d[0];
            int c = j+d[1];
            
            if(r<0 || c<0 || r>=h || c>=w || seen.contains(r+"_"+c))
                continue;

            char ch = board[r][c];
            if(curr.arr[ch-'a']==null || curr.arr[ch-'a'].cnt==0)
                continue;


            
            if(curr.arr[ch-'a'].isWord)
                res.add(curr.arr[ch-'a'].str);
            
            seen.add(r+"_"+c);
            helper(curr.arr[ch-'a'], seen, r, c, res, board);
            seen.remove(r+"_"+c);
        }
        
        
    /*

    [["o","a","a","n"]
    ,["e","t","a","e"]
    ,["i","h","k","r"]
    ,["i","f","l","v"]]
    */
        
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
    
    private void buildTrie(String[] words){
        root = new TrieNode();
        
        for(String w : words){
            
            TrieNode curr = root;
            for(char ch : w.toCharArray()){
                if(curr.arr[ch-'a']==null){
                    curr.arr[ch-'a'] = new TrieNode();
                    curr.arr[ch-'a'].str = curr.str+ch;
                    curr.cnt++;
                }
                curr = curr.arr[ch-'a'];
            }

            curr.cnt++;
            curr.isWord = true;
        }
        
    }
}