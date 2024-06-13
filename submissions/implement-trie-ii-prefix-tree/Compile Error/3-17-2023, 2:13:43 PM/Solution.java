// https://leetcode.com/problems/implement-trie-ii-prefix-tree

class Trie {

    class TrieNode{
        
        TrieNode[] arr = new TrieNode[26];
        boolean isWord =false;
        int wordCnt =0;
        int prefixCnt =0;
        
        public TrieNode(){
            arr = new TrieNode[26];
            isWord = false;
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
            node.prefixCnt++;
        }
        node.wordCnt++;
        node.isWord=true;
    }
    
    public int countWordsEqualTo(String word) {
        
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            
            if(node.arr[ch-'a']==null){
                return 0;
            }
            node = node.arr[ch-'a'];
        }
        
        return node.wordCnt;
    }
    
    
    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            
            if(node.arr[ch-'a']==null){
                return 0;
            }
            node = node.arr[ch-'a'];
        }
        
        return node.prefixCnt;
    }
    
    public void erase(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            
            TrieNode tmp = node.arr[ch-'a'];
            tmp.prefixCnt--;
            
            if(tmp.prefixCnt==0){
                node.arr[ch-'a']=null;
            }
            
            node = tmp
            
        }
        node.wordCnt--;
        if(node.wordCnt==0)
            node.isWord=false;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */