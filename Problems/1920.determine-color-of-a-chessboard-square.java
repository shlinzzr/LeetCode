// https://leetcode.com/problems/determine-color-of-a-chessboard-square

class Solution {
    public boolean squareIsWhite(String coordinates) {
        char w = coordinates.charAt(0);
        char n = coordinates.charAt(1);
         // System.out.println((w-'a')%2);
         return ((w-'a')%2) + ((n-'1')%2)==1;
    }
}