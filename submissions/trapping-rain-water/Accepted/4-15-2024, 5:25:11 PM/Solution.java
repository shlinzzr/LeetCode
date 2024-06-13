// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for(int i=1; i<len; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        int[] rightMax = new int[len];
        rightMax[len-1] = height[len-1];
        for(int i=len-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        int res =0 ;
        for(int i=1; i<len-1; i++){
            int bar =  Math.min(leftMax[i-1], rightMax[i+1]);
            
            if(bar-height[i]>0)
                res+=bar-height[i];
            // System.out.println(i + " val="+val);
                    
            
        }
        
        return res;
    }
}