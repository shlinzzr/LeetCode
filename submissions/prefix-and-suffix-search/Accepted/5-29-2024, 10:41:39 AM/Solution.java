// https://leetcode.com/problems/prefix-and-suffix-search

class TrieNode {
    TrieNode[] children;
    int idx;
    public TrieNode() {
        children = new TrieNode[27]; // 'a' - 'z' and '{'. 'z' and '{' are neighbours in ASCII table
        idx = 0;
    }
}

// sol ref : https://leetcode.com/problems/prefix-and-suffix-search/solutions/144432/java-beat-95-just-small-modifications-in-implementing-trie/
// 分析 : https://leetcode.com/problems/prefix-and-suffix-search/solutions/110044/three-ways-to-solve-this-problem-in-java/

public class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int idx = 0; idx < words.length; idx++) {
            String word = words[idx] + "{";
            for (int i = 0; i < word.length(); i++) {
                TrieNode cur = root;
                cur.idx = idx;
                // 012345678910    
                // apple{apple
                // apple{ => word.length()=6
                // i
                // j , from i to 211
    // add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    cur = cur.children[k];
                    cur.idx = idx;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        TrieNode cur = root;
        for (char c: (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return -1;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.idx;
    }
}