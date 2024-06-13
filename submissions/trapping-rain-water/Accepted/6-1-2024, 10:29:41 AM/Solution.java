// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] h) {

        int len = h.length;

        int[] leftMax = new int[len];
        for(int i=0; i<len; i++){
            leftMax[i] = i==0 ? h[0] : Math.max(h[i], leftMax[i-1]);
        }

        int[] rightMax = new int[len];
        for(int i=len-1; i>=0; i--){
            rightMax[i] = i==len-1 ? h[len-1] : Math.max(h[i], rightMax[i+1]);
        }


        int res = 0;
        for(int i=1; i<len-1; i++){
            res += Math.min(leftMax[i], rightMax[i])-h[i];
        }

        return res;
        
    }
}