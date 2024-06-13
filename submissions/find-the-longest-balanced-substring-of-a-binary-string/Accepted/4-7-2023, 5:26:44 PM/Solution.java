// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        
        
        int max =0;
        int len = s.length();
        String temp = "01";
        while(s.contains(temp)){
            max = Math.max(max, temp.length());
            temp = "0" + temp + "1";
        }
        
        return max;
    }
}

