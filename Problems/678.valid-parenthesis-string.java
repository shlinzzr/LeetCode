// https://leetcode.com/problems/valid-parenthesis-string

public class Solution {
    public boolean checkValidString(String s) {

        int leftMax = 0; // count * as '(' as much as we can
        int leftMin = 0; // count * as ')' as much as we can
        

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMax++;
                leftMin++;
                
            } else if (c == ')') {
                leftMax--;
                leftMin--;
                
            } else {
                leftMax++; // as '('
                leftMin--; // as ')'
            }
            if (leftMax < 0) return false; // we have already make * as '(' as much as we can, but still is not enough '('
            if (leftMin < 0) leftMin = 0; // force '*' change to '('
        }
        
        return leftMin == 0;
    }
}