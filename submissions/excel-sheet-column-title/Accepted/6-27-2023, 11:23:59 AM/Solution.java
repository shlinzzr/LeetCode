// https://leetcode.com/problems/excel-sheet-column-title

class Solution {
    public String convertToTitle(int n) {
        String res = "";
        
        
        while(n>0){
            
            int mod = (n-1)%26;
            
            n = (n-1)/26;
            res = (char) ((mod)+'A') + res;
        }
        
        return res;
        
    }
}