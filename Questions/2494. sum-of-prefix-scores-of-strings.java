// https://leetcode.com/problems/sum-of-prefix-scores-of-strings

class Trie {
    Trie[] arr = new Trie[26];
    int visited = 0;
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int[] ans = new int[words.length];
        int k = 0;
        for (String w: words) {
            Trie tmp = trie;
            for (int i = 0; i < w.length(); i++) {
                int ch = w.charAt(i) - 'a';
                if (tmp.arr[ch] == null) tmp.arr[ch] = new Trie();
                tmp.arr[ch].visited++;
                tmp = tmp.arr[ch];
            }
        }
        for (String w: words) {
            Trie tmp = trie; int curr = 0;
            for (int i = 0; i < w.length(); i++) {
                int ch = w.charAt(i) - 'a';
                curr += tmp.arr[ch].visited;
                tmp = tmp.arr[ch];
            }
            ans[k++] = curr;
        }
        return ans;
    }
}