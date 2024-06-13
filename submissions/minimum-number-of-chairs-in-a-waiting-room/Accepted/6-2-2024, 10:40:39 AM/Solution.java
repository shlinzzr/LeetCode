// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room

class Solution {
    public int minimumChairs(String s) {
        int cnt=0, max=0;
        for(char ch : s.toCharArray()){
            if(ch=='E') cnt++;
            else cnt--;
            max = Math.max(max, cnt);
        }
        
        return max;
        
    }
}