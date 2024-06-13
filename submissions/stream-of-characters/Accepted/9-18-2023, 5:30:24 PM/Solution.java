// https://leetcode.com/problems/stream-of-characters

class StreamChecker {

    class TrieNode {
        
        TrieNode[] arr;
        boolean isWord;
        public TrieNode(){
            arr = new TrieNode[26];
        }        
    }
    
    TrieNode root;
    StringBuilder sb;
    
  
    public StreamChecker(String[] words) {
        
        root = new TrieNode();        
        sb = new StringBuilder();
        
        for(String w : words){
            
            TrieNode node = root;
            
            for(int i=w.length()-1; i>=0; i--){
                
                char ch = w.charAt(i);
                if(node.arr[ch-'a']==null){
                    node.arr[ch-'a'] = new TrieNode();
                }                
                node = node.arr[ch-'a'];
            }
            node.isWord=true;
        }
    }
    
//     public boolean query(char letter) {
        
//         sb.insert(0, letter);
//         // sb.append(letter);
        
//         TrieNode node = root;
//         for(int i=sb.length()-1; i>=0; i--){
//             char ch = sb.charAt(i);
//             if(node!=null && node.isWord){
//                 return true;
//             }   
//             if(node==null)
//                 return false;

//             node = node.arr[ch-'a'];

//         }
//         return false;
//     }
    
      
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.arr[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }
    
    
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */