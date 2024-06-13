// https://leetcode.com/problems/replace-words

class Solution {

    class TrieNode{

        TrieNode[] arr;
        boolean isWord;
        String s;
        public TrieNode(){
            arr = new TrieNode[26];
        }
    }
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        for(String s: dictionary){

            TrieNode curr = root;
            for(char ch : s.toCharArray()){
                if(curr.arr[ch-'a']==null){
                    curr.arr[ch-'a'] = new TrieNode();
                }
                curr = curr.arr[ch-'a'];
            }
            curr.s = s;
            curr.isWord = true;
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String w : words){
            TrieNode curr = root;

            for(char ch : w.toCharArray()){
                if(curr.arr[ch-'a']==null){
                    if(!sb.isEmpty())
                        sb.append(" ");
                    sb.append(w);
                    break;
                }else{
                    curr = curr.arr[ch-'a'];
                    if(curr.isWord){
                        if(!sb.isEmpty())
                            sb.append(" ");
                        sb.append(curr.s);
                        break;
                    }
                }
            }
        }

        return sb.toString();


    
        
    }
}