// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        int max =0;
        
        int cur =0;
        for(int g: gain){
            cur+=g;
            max = Math.max(max, cur);
            
        }
        return max;
    }
}