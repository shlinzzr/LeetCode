// https://leetcode.com/problems/can-convert-string-in-k-moves

class Solution {
    public boolean canConvertString(String s, String t, int k) {
        // Edge case
        if (s.length() != t.length()) {
            return false;
        }

        // Other cases Scenario
        int[] character = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
            character[shift]++;
        }

        
        for (int i = 1; i < 26; i++) {
            if (i + (character[i] - 1) * 26 > k) { 
                //i means the char move : "a"->"c"
                // (character[i] - 1) * 26 :  means have to wait the whole round (26) to do char move
                return false;
            }
        }
        return true;
    }
}