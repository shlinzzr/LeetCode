// https://leetcode.com/problems/word-squares

class Solution {
    class TrieNode {
        TrieNode[] children;
        List<String> list;

        public TrieNode() {
            children = new TrieNode[26];
            list = new ArrayList<>();    
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
                curr.list.add(word);
            }        
        }
        
        public List<String> startsWith(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null) {
                    return new ArrayList<>();
                }
                curr = curr.children[c - 'a'];
            }
            return curr.list;
        }
    }
    
    TrieNode root;
    List<List<String>> result;

    public List<List<String>> wordSquares(String[] words) {
        if(words == null || words.length == 0) {
            return new ArrayList<>();
        }
        
        root = new TrieNode();   
        result = new ArrayList<>();
        
        for(String word : words) {
            root.insert(word);    
        }
        
        List<String> temp = new ArrayList<>();
        
        for(String word : words) { //嘗試所有起點
            //action
            temp.add(word);
            //recurse
            backtrack(temp, word);
            //backtrack
            temp.remove(temp.size() - 1);
        }
        
        return result;
    }
    
    private void backtrack(List<String> temp, String word) {
        //base
        if(temp.size() == word.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        //logic
        StringBuilder prefix = new StringBuilder();
        int i = temp.size();
        for(String s : temp) {
            prefix.append(s.charAt(i));
        }
        
        List<String> allStrings = root.startsWith(prefix.toString());
        
        for(String s : allStrings) {
            //action 
            temp.add(s);
            //recurse
            backtrack(temp, word);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}