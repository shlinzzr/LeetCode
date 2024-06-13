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
    
    public boolean query(char letter) {
        
        
        
        
        
        sb.insert(0, letter);
        for(int i=1; i<=sb.length(); i++){
            
            if(find(sb.substring(0, i)))
                return true;
        }
        return false;
    }
    
    
    private boolean find(String w){
        TrieNode node = root;
        for(int i=0; i<w.length(); i++){

            char ch = w.charAt(i);
            
            
            if(node.arr[ch-'a']==null){
                return false;
            }                
            node = node.arr[ch-'a'];
        }
        
        return node.isWord;
        
        
        
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */