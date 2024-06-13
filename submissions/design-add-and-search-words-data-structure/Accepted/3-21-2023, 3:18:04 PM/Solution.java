// https://leetcode.com/problems/design-add-and-search-words-data-structure

class WordDictionary {

    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord;
        
        public TrieNode(){
            this.arr = new TrieNode[26];
        }
            
    }
    
    TrieNode root;
    
    public WordDictionary() {
        
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.arr[ch-'a']==null)
                node.arr[ch-'a'] = new TrieNode();
            node = node.arr[ch-'a'];
        }
        
        node.isWord=true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    
    private boolean match(char[] arr, int idx, TrieNode node){
        if(node==null)
            return false;
        
        if(idx==arr.length)
            return node.isWord;
        
        if(arr[idx]!='.'){
            char ch = arr[idx];
            return match(arr, idx+1, node.arr[ch-'a']);
        }else{
            
            for(char ch='a'; ch<='z'; ch++){
                if(match(arr, idx+1, node.arr[ch-'a'])){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */