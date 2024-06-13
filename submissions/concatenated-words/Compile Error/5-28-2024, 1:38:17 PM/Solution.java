// https://leetcode.com/problems/concatenated-words

class Solution {

    TrieNode root;

    class TrieNode {
        TrieNode[] arr;
        boolean isWord;

        int wordCnt = 0;


        public TrieNode(){
            arr = new TrieNode[26];
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();

        List<String> res = new ArrayList<>();

        
        // buildmap
        for(String w : words){
            TrieNode curr = root;
            for(char ch : w.toCharArray()){
                if(curr[ch-'a']==null){
                    curr[ch-'a'] = new TrieNode();
                }
                curr = curr[ch-'a'];
            }
            curr.isWord = true;
        }

        // find map
        for(String w : words){
            TrieNode curr = root;
            int cnt = 0;
            for(char ch : w.toCharArray()){
                curr = curr.arr[ch-'a'];
                if(curr.isWord) cnt++;
            }
            
            if(curr.isWord)
            
        }  


    }
}