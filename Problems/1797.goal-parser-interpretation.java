// https://leetcode.com/problems/goal-parser-interpretation

class Solution {
    public String interpret(String s) {
        s = s.replaceAll("\\(\\)", "o");
        
        s = s.replaceAll("\\(al\\)", "al");
        
        return s;
    }
}