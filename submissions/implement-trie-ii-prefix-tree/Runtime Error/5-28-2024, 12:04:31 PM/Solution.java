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
    Map<String, Integer> map;

    public Trie() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String word) {
        
        map.put(word, map.getOrDefault(word,0)+1);
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.arr[ch-'a']==null){
                curr.arr[ch-'a'] = new TrieNode();
            }
            curr = curr.arr[ch-'a'];
            curr.prefixCnt++;
        }
        curr.wordCnt++;
        curr.isWord = true;
        
    }
    
    public int countWordsEqualTo(String word) {
        return map.get(word);
        
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.arr[ch-'a']==null) return 0;
            curr = curr.arr[ch-'a'];
        }

        return curr.prefixCnt;    
    }
    
    public void erase(String word) {
        if(map.containsKey(word)){
            map.put(word, map.get(word)-1);
            if(map.get(word)==0) map.remove(word);
        }
            

        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.arr[ch-'a']==null) return;
            curr = curr.arr[ch-'a'];
            curr.prefixCnt--;
        }

        
        
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