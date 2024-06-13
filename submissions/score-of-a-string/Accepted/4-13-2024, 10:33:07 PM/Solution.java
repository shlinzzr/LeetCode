// https://leetcode.com/problems/score-of-a-string

class Solution {
    public int scoreOfString(String s) {
        
        char[] arr = s.toCharArray();
        
        int res = 0; 
        
        for(int i=0; i<s.length()-1; i++){
            char a = arr[i];
            char b = arr[i+1];
            res+= Math.abs(a-b) ;
        }
        
        return res;
        
    }
}