// https://leetcode.com/problems/decoded-string-at-index

class Solution {
    public String decodeAtIndex(String s, int K) {
        long N = 0;
        int i=0;
        for (i = 0; N < K; ++i)
            N = Character.isDigit(s.charAt(i)) ? N * (s.charAt(i) - '0') : N + 1;
        while (i-->0)
            if (Character.isDigit(s.charAt(i))){
                N /= s.charAt(i) - '0';
                K %= N;
            }
                
            else if (K % N-- == 0)
                return s.charAt(i)+"";
        return "lee215";
    }
}