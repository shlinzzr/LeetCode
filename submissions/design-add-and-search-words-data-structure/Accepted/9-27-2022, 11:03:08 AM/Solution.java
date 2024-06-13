// https://leetcode.com/problems/design-add-and-search-words-data-structure

class WordDictionary {

   // TrieNode
    
    public class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    TrieNode root = null;
    public WordDictionary() {
        root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode();
            node = node.children[c-'a'];
        }
        node.isWord=true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return node.isWord;   
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
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