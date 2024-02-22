// https://leetcode.com/problems/implement-trie-prefix-tree

class Trie {

    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord;
        
        public TrieNode(){
            arr = new TrieNode[26];
            isWord=false;
        }
        
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.arr[ch-'a']==null){
                node.arr[ch-'a'] = new TrieNode();
            }
            node = node.arr[ch-'a'];
        }
        node.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            
            if(curr.arr[ch-'a']==null)
                return false;
            else{
                curr = curr.arr[ch-'a'];
            }
        }
        
      
        if(curr.isWord==false)
            return false;
        
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            
            if(curr.arr[ch-'a']==null)
                return false;
            else
                curr= curr.arr[ch-'a'];
        }
        
        return true;
            
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */