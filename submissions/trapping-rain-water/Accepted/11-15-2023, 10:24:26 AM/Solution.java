// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int len = height.length;

        int[] leftMax = new int[len];
        int max= 0 ;
        for(int i=0;i<len; i++){
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }

        int [] rightMax = new int[len]; 
        max = 0;
        for(int i=len-1; i>=0; i--){
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }

        int res = 0;
        for(int i=0; i<len; i++){
            res += Math.min(leftMax[i], rightMax[i])-height[i];
        }

        return res;
    }
}