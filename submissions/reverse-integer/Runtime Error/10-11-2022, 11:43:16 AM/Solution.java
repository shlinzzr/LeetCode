// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(x));
        return Integer.valueOf(sb.reverse().toString());
    }
}