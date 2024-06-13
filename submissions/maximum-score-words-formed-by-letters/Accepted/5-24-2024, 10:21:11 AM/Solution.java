// https://leetcode.com/problems/maximum-score-words-formed-by-letters

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0) return 0;


        int[] arr = new int[score.length];
        for (char ch : letters) {
            arr[ch-'a']++;
        }
        int res = backtrack(words, arr, score, 0);
        return res;
    }
    int backtrack(String[] words, int[] arr, int[] score, int index) {
        int max = 0;
        for (int i = index; i < words.length; i++) {
            int res = 0;
            boolean isValid = true;
            for (char ch : words[i].toCharArray()) {
                arr[ch - 'a']--;
                res += score[ch - 'a'];
                if (arr[ch - 'a'] < 0) isValid = false;
            }
            if (isValid) {
                res += backtrack(words, arr, score, i + 1);
                max = Math.max(res, max);
            }

            // recover
            for (char ch : words[i].toCharArray()) {
                arr[ch - 'a']++;
                res = 0;
            }
        }
        return max;
    }
}