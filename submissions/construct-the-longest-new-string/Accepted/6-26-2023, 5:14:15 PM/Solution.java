// https://leetcode.com/problems/construct-the-longest-new-string

class Solution {
    
     public int longestString(int x, int y, int z) {
        return (Math.min(x, y + 1) + Math.min(x + 1, y) + z) * 2;
    }
    
}