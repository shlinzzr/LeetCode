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
        
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(c=='.'){
                
                boolean find = false;
                for(TrieNode child : curr.children){
                    if(child!=null){
                        curr = child;
                        find=true;
                        break;
                    }
                }
                if(find==false)
                    return false;
                
            }else{
                if(curr.children[c-'a']!=null)
                    curr = curr.children[c-'a'];
                else 
                    return false;
            }
            
           
        }
        
        return curr.isWord;
    }
    
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */