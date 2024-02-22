// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        
        int[] leftMax = new int[len];
        
        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        
        int[] rightMax = new int[len];
        max=0;
        
        for(int i=len-1; i>=0; i--){
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        
        int res =0 ;
        for(int i=1; i<len-1; i++){
            int val =  Math.min(leftMax[i-1], rightMax[i+1])-height[i];
            
            if(val>0)
                res+=val;
            // System.out.println(i + " val="+val);
                    
            
        }
        
        return res;
    }
}