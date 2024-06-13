// https://leetcode.com/problems/palindrome-pairs

class Solution {
    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;
            
        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            
            list  = new ArrayList<>();
        }
    }
        
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();
            
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i); // add reverse w into trie
        }
            
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
        
        return res;
    }
        
    private void addWord(TrieNode curr, String word, int index) {

        int len = word.length();
        for (int i = len-1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
                    
            if (curr.next[j] == null) {
                curr.next[j] = new TrieNode();
            }
                    
            if (isPalindrome(word, 0, i)) { // if prefix is pal , then we can add it to list
                curr.list.add(index);
            }
                    
            curr = curr.next[j];
        }
            
        curr.list.add(index);
        curr.index = index;
    }
        
    private void search(String[] words, int i, TrieNode curr, List<List<Integer>> res) {

        String w = words[i];

        for (int j = 0; j < w.length(); j++) {	// curr = ab   w= ab"pal"     
            // if( isWord && is not the same node &&  isPal(w.suffix) )
            if (curr.index >= 0 && curr.index != i && isPalindrome(w, j, w.length() - 1)) {
                res.add(Arrays.asList(i, curr.index));
            }
                
            curr = curr.next[w.charAt(j) - 'a'];
            if (curr == null) return;
        }
            
        for (int j : curr.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }
        
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
            
        return true;
    }
}