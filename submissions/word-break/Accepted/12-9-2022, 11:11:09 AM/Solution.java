// https://leetcode.com/problems/word-break

class Solution {
    
    private class TrieNode{
        TrieNode[] arr;
        boolean isWord;
        
        public TrieNode(){
            arr = new TrieNode[26];
            isWord=false;
        }
    }
    
    TrieNode root = new TrieNode();
    int[] memo = new int[301];
    
    public boolean wordBreak(String s, List<String> wordDict) {
       
        // solution 2 : use Trie => TLE
        // enhance : add cache memo
        
        for(String w : wordDict){
            TrieNode node = root;
            
            for(char c : w.toCharArray()){
                if(node.arr[c-'a']==null){
                    node.arr[c-'a'] = new TrieNode();
                }
                node = node.arr[c-'a'];
            }
            node.isWord=true;
        }
        
        
        return dfs(s, 0);
        
        
    }
    
    private boolean dfs(String s, int curr){
        
        if(curr==s.length())
            return true;
        
        if(memo[curr]==1)
            return false;
        
        
        TrieNode node = root;
        
        for(int i=curr; i<s.length(); i++){
            char c = s.charAt(i);
            if(node.arr[c-'a']!=null){
                
                node = node.arr[c-'a'];
                if(node.isWord==true && dfs(s, i+1)){
                    return true;
                }
            }else{
                break;
            }
        }
        
        memo[curr]=1;
        return false;
    }
    
    
    
    
    
}