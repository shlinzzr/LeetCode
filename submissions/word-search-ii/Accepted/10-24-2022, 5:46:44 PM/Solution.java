// https://leetcode.com/problems/word-search-ii

class Solution {
    
    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord = false;
        int count;
        
        public TrieNode(){
            arr = new TrieNode[26];
            isWord = false;
            count=1;
        }
    }
    
    TrieNode root;
    List<String> res;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    boolean[][] seen;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        root = new TrieNode();
        for(String word : words){
            
            TrieNode node = root;
            
            for(char ch : word.toCharArray()){
                
                if(node.arr[ch-'a']==null){
                    node.arr[ch-'a'] = new TrieNode();
                }
                node.count++;
                node = node.arr[ch-'a'];
            }
            node.isWord=true;
            
        }
        
        int h = board.length;
        int w = board[0].length;
        seen = new boolean[h][w];
        res = new ArrayList<>();
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                TrieNode node = root;
                seen[i][j]=true;
                dfs(board, i, j, node, "");
                seen = new boolean[h][w];
            }
        }
        res = new ArrayList<>(new HashSet<>(res));
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, String s){
        
        int h = board.length;
        int w = board[0].length;
        char ch = board[i][j];
        
        if(node.arr[ch-'a']==null) return;
        
        node = node.arr[ch-'a'];
        if(node.count==0)
            return;
        s+=ch;
        
        if(node.isWord==true){
            remove( s);
            node.isWord=false;
            res.add(s);
        }
            
        
        
        for(int[] d : dirs){
            int r = i+d[0];
            int c = j+d[1];
            
            if(r<0 || r>=h || c<0 || c>=w  ||seen[r][c]==true)
                continue;
            
            seen[r][c] = true;
            dfs(board, r, c, node, s);
            seen[r][c] = false;
        }
        
        s = s.substring(0, s.length()-1);
        
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
    
    
//     private void dfs(char[][] board, int i, int j, String word, int idx){
        
//         if(idx==word.length()-1){
//             res.add(word);
//             return;
//         }
        
//         int h = board.length;
//         int w = board[0].length;
        
//         int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
//         for(int[] d : dirs){
//             int r = i+d[0];
//             int c = j+d[1];
            
//             if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false && board[r][c]==word.charAt(idx+1)){
//                 seen[r][c]=true;
//                 dfs(board, r, c, word, idx+1);
//                 seen[r][c]=false;
//             }
//         }
        
        
        
//     }
    
    
//     private void dfs(char[][] board, int i, int j, String word, int idx){
        
//         int h = board.length;
//         int w = board[0].length;
        
//         Queue<int[]> queue = new LinkedList<>();
//         queue.add(new int[]{i, j});
//         seen[i][j]=true;
//         int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        
//         while(!queue.isEmpty()){
            
//             if(idx==word.length()-1){
//                 res.add(word);
//                 return;
//             }
            
//             int siz = queue.size();
            
//             for(int s=0; s<siz;s++){
//                int[] p = queue.poll();

//                 for(int[] d : dirs){
//                     int r = p[0]+d[0];
//                     int c = p[1]+d[1];
//                     if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false){
//                         if(board[r][c]==word.charAt(idx+1)){
//                             System.out.println(board[r][c] + " "+ idx);
//                             seen[r][c]=true;
//                             queue.add(new int[]{r,c});
                            
//                         }else{
//                             seen[r][c]=false;
//                         }
//                     }
                        
//                 } 
//             }
//             idx++;
//         }
    // }
}


/*
[["o","a","b","n"],
 ["o","t","a","e"],
 ["a","h","k","r"],
 ["a","f","l","v"]]
 
 ["oa","oa","oaa"]
 
 
 [["a","b","c"],
  ["a","e","d"],
  ["a","f","g"]]
  
  
["befa","abcdefg","gfedcbaaa"]
  
 */



