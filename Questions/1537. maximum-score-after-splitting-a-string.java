// https://leetcode.com/problems/maximum-score-after-splitting-a-string

class Solution {
    public int maxScore(String s) {
        int max = 0;
        int zerosLeft = 0;
        int onesRight = countOnes(s); 
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosLeft++;
            } else {
                onesRight--;
            }
            max = Math.max(max, zerosLeft + onesRight);
        }
        return max;
    }

    private int countOnes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}