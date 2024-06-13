// https://leetcode.com/problems/implement-trie-prefix-tree

class Trie {

    TrieNode root;
    
    public Trie() {
         root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char c  : word.toCharArray()){
            if(node.arr[c-'a']==null){
                node.arr[c-'a'] = new TrieNode();
            }
            node = node.arr[c-'a'];
        }
        node.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char c  : word.toCharArray()){
            if(node.arr[c-'a']==null)
                return false;
            node = node.arr[c-'a'];
        }
        
        if(node.isWord)
            return true;
        else 
            return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c  : prefix.toCharArray()){
            if(node.arr[c-'a']==null)
                return false;
            node = node.arr[c-'a'];
        }
        
        return true;
    }
   
    
    public class TrieNode{
        
        TrieNode[] arr ;
        boolean isWord;
        
        public TrieNode(){
            arr = new TrieNode[26];
        }
    }
}






/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */