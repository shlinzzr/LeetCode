// https://leetcode.com/problems/score-of-a-string

class Solution {
    public int scoreOfString(String s) {
        int cnt=0;
        int len = s.length();
        for(int i=0; i<len-1; i++){
            cnt += Math.abs(s.charAt(i)-s.charAt(i+1));
        }

        return cnt;
        
    }
}