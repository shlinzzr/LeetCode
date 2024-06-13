// https://leetcode.com/problems/stream-of-characters

class StreamChecker {
    
    class TrieNode{
        TrieNode[] arr;
        boolean isWord;
        
        public TrieNode(){
            arr = new TrieNode[26];
        }
    }
    
    TrieNode root;
    List<Character> list;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        
        
        for(String w : words){
            TrieNode curr = root;
            for(int i=w.length()-1; i>=0; i--){
                char ch = w.charAt(i);
                if(curr.arr[ch-'a']==null){
                    curr.arr[ch-'a'] = new TrieNode();
                }
                curr = curr.arr[ch-'a'];
            }
            curr.isWord=true;
        }
        
        
        list = new ArrayList<>();
        
    }
    
    public boolean query(char letter) {
        
        list.add(letter);
        
        TrieNode curr = root;
        for(int i=list.size()-1; i>=0; i--){
            char ch = list.get(i);
            if(curr.arr[ch-'a']==null) return false;
            else curr = curr.arr[ch-'a'];
            
            if(curr.isWord) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */