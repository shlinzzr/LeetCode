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
        
        for (int k = 0; k < 10; k++) {
            
            int[][] count = new int[6][26];
            int best = 0;
            for(String word: words){
                for(int i=0; i<6; i++){
                    count[i][word.charAt(i)-'a']++;
                }
            }
            
            String guess = words[0];
            for(String word : words){
                int score = 0;
                for(int i=0; i<6; i++){
                    score += count[i][word.charAt(i)-'a'];
                }
                if(score > best){
                    guess = word;
                    best = score;
                }
            }
            
            int similarity = master.guess(guess);
            List<String> temp = new ArrayList<>();
            for(String word : words){
                if(match(guess, word)==similarity){
                    temp.add(word);
                }
            }
            
            words = temp.toArray(new String[0]);
            
            
            
//             int randomIdx = random.nextInt(list.size());
//             String cur = list.get(randomIdx);
//             int val = master.guess(cur);
//             if (val == 6) {
//                 return;
//             }
            
//             List<String> updateList = new ArrayList<>();
//             for (String str : list) {
//                 if (str.equals(cur)) {
//                     continue;
//                 }
//                 if (val == similar(str, cur)) {
//                     updateList.add(str);
//                 }
//             }
//             list = updateList;
        }
    }
    
    private int match(String word1, String word2) {
        
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}