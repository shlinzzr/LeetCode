// https://leetcode.com/problems/single-row-keyboard

class Solution {
    public int calculateTime(String keyboard, String word) {
        int cnt=0;
        int prev=0;
        for(char ch : word.toCharArray()){
            cnt+=Math.abs(prev-keyboard.indexOf(ch));
            prev = keyboard.indexOf(ch);
        }
        
        return cnt;
    }
}