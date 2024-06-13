// https://leetcode.com/problems/excel-sheet-column-number

class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        
        int cur = 0;
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            
            cur = cur*26 + ch-'A';
        }
        
        return cur+1;
        
    }
}