// https://leetcode.com/problems/word-squares

class Solution {

    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        List<String> list;

        public TrieNode() {
            children = new TrieNode[26];
            list = new ArrayList<>();    
        }

        public void insert(String word) {
            list.add(word);
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
                curr.list.add(word);
            }
        }

        public List<String> startsWith(String prefix){
            TrieNode curr = root;
            for(char ch : prefix.toCharArray()){
                if(curr.children[ch-'a']==null)
                    return new ArrayList<>();
                else{
                    curr = curr.children[ch-'a'];
                }
            }
            return curr.list;
        }

    }

    public List<List<String>> wordSquares(String[] words) {

        if(words == null || words.length == 0) {
            return new ArrayList<>();
        }

        root = new TrieNode();
        List<List<String>> res = new ArrayList<>();

        for(String word : words) {
            root.insert(word);    
        }
    
        List<String> curr = new ArrayList<>();
        for(String w : words){
            curr.add(w);
            backtrack(res, curr, w);
            curr.remove(curr.size()-1);
        }
        return res;
    }

    private void backtrack( List<List<String>> res, List<String> curr, String w){

        if(curr.size()==w.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        StringBuilder prefix = new StringBuilder();

        int siz = curr.size();
        for(String s: curr){
            prefix.append(s.charAt(siz));
        }

        List<String> candidates = root.startsWith(prefix.toString());
        for(String s : candidates){
            curr.add(s);
            backtrack(res, curr, w);
            curr.remove(curr.size()-1);
        }
    }

}




/* 

b a l l 
a r e a
l e a d
l a d y

*/