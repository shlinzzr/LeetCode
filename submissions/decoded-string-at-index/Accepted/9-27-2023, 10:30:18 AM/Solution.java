// https://leetcode.com/problems/decoded-string-at-index

class Solution {
    public String decodeAtIndex(String S, int K) {
        
        long curLength = 0;
        char ch = 0;
        
        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (Character.isDigit(ch)) { // a1
                curLength *= ch - '0';
            }
            else { // b1
                curLength++;
            }
        }
        
        for (int i = S.length() - 1; i >= 0; i--) {
            ch = S.charAt(i);
            if (Character.isDigit(ch)) { // a2
                curLength /= (ch - '0');
                K %= curLength;
            }
            else { // b2
                if (K == 0 || K == curLength) {
                    return "" + ch;
                }
                curLength--;
            }
        }
        
        throw null;
    }
}