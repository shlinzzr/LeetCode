// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        
        int totalLen = 0;
        
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int len = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < sLen - len*wordLen + 1; i++) {
            String sub = s.substring(i, i + len * wordLen);
            if (isConcat(sub, counts, wordLen)) {
                res.add(i);
            }
        }
        return res;
    }
    
    /**
     * */
    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < sub.length(); i += wordLen) {
            
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }
}
