// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters

public class Solution {
    public int longestSubstring(String s, int k) {
        
        int len = s.length();
        
        if (s == null || len == 0) 
            return 0;
        
        char[] arr = new char[26];
        // record the frequency of each character
        for (int i = 0; i <len;  i++) 
            arr[s.charAt(i) - 'a']++;
        
        
        // check init edge case
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (arr[i] < k && arr[i] > 0) flag = false;
        }
        if (flag) 
            return len;
        
        
        int result = 0;
        int start = 0, ed = 0;
        // otherwise we use all the infrequent elements as splits
        while (ed < len) {
            if (arr[s.charAt(ed) - 'a'] < k) {
                result = Math.max(result, longestSubstring( s.substring(start, ed), k));
                start = ed + 1;
            }
            ed++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}