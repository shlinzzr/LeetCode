// https://leetcode.com/problems/design-add-and-search-words-data-structure

class WordDictionary {

    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord;
        
        public TrieNode(){
            arr = new TrieNode[26];
             isWord = false;
        }
        
    }
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.arr[ch-'a']==null)
                curr.arr[ch-'a']=new TrieNode();
            
            curr = curr.arr[ch-'a'];
        }
        curr.isWord=true;
    }
    
    public boolean search(String word) {
        
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] arr, int k, TrieNode node) {
        if(node==null)
            return false;
        
        if(k==arr.length)
            return node.isWord;
        
        if(arr[k]!='.'){
            char ch = arr[k];
            return match(arr, k+1, node.arr[ch-'a']);
        }else{
            
            for(char dot='a'; dot<='z'; dot++){
                
               if (node.arr[dot-'a'] != null) {
                    if (match(arr, k + 1, node.arr[dot-'a'])) {
                        return true;
                    }
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