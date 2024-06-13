// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix

class Solution {
    
    public class TrieNode{
        TrieNode[] arr;
        boolean isAns;
        
        public TrieNode(){
            arr = new TrieNode[10];
        }
        

    }
    
    TrieNode root;
    
    int max = 0;
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        
        root = new TrieNode();
        
        for(int a : arr1){
            TrieNode curr = root;
            String s = a+"";
            
            for(char ch : s.toCharArray()){
                if(curr.arr[ch-'0']==null){
                    curr.arr[ch-'0'] = new TrieNode();
                }
                curr = curr.arr[ch-'0'];
            }
            curr.isAns = true;
        }
        
        
        int cnt= 0;
        
        for(int b : arr2){
          
            String s = b+"";
            if(isPrefix(root, s)){
                cnt++;
            }
            
        }
        
        return max;
        
       
    }
    
    private boolean isPrefix(TrieNode root, String s){
        
        
        TrieNode curr = root;
        int prefix = 0;
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(curr.arr[ch-'0']==null) return false;
            max = Math.max(max, i+1);
            
            curr = curr.arr[ch-'0'];
            
        }
        
        
        return curr.isAns;
    }
    
}