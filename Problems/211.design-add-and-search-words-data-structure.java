// https://leetcode.com/problems/design-add-and-search-words-data-structure

class WordDictionary {

    class TrieNode{

        TrieNode[] arr ;
        boolean isWord;
        public TrieNode(){
            arr = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.arr[ch-'a']==null){
                curr.arr[ch-'a'] = new TrieNode();
            }

            curr = curr.arr[ch-'a'];
        }
        curr.isWord = true;
        
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

    // public boolean search(String word) {
    //     TrieNode curr = root;
    //     for(int i=0; i<word.length(); i++){
    //         char ch = word.charAt(i);
    //         if(ch=='.'){
    //             boolean flag = false;
    //             for(char c='a'; c<='z'; c++){
    //                 if(curr.arr[c-'a']!=null)
    //                     flag |= helper(word, i+1, curr.arr[c-'a']);
    //             }
    //             break;
    //         }
    //         if(curr.arr[ch-'a']==null) return false;
    //         curr = curr.arr[ch-'a'];
    //     }
    //     return curr.isWord;
        
    // }
    // private boolean helper(String w , int idx, TrieNode curr){

    //     for(int i=idx; i<w.length(); i++){
    //         char ch = w.charAt(idx);
    //         if(ch=='.'){
    //             boolean flag = false;
    //             for(char c='a'; c<='z'; c++){
    //                 if(curr.arr[c-'a']!=null){
    //                     flag |= helper(w, i+1, curr.arr[c-'a']);
    //                 }
                    
    //             }
    //             break;
    //         }
    //     }
    //     return curr.isWord;
    // }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */