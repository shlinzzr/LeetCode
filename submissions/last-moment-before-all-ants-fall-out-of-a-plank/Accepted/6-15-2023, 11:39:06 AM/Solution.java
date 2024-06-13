// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        
        int rightMost = 0;
        int leftMost = n;
        
        for(int l : left){
            rightMost = Math.max(rightMost, l);
        }
        
        for(int r: right){
            leftMost = Math.min(leftMost, r);
        }
        
        
        return  Math.max(n-leftMost, rightMost);
        
    }
}