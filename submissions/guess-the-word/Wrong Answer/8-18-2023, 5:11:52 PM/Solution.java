// https://leetcode.com/problems/guess-the-word

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */

class Solution {
    public void findSecretWord(String[] words, Master master) {
        
        // cc
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        
        Random random = new Random();
        List<String> list = Arrays.asList(words);
        for (int i = 0; i < 10; i++) {
            int randomIdx = random.nextInt(list.size());
            String cur = list.get(randomIdx);
            int val = master.guess(cur);
            if (val == 6) {
                return;
            }
            
            List<String> updateList = new ArrayList<>();
            for (String str : words) {
                if (str.equals(cur)) {
                    continue;
                }
                if (val == similar(str, cur)) {
                    updateList.add(str);
                }
            }
            list = updateList;
        }
    }
    
    private int similar(String word1, String word2) {
        
        int res = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}