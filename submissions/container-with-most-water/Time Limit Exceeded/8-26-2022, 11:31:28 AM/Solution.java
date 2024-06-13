// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        
        for(int i=0; i<height.length-1; i++){
            for(int j=i+1; j<height.length; j++){
                
                int vol = Math.min(height[i], height[j])*(j-i);
                max = Math.max(max, vol);
                
                
                
            }
        }
        
        return max;
    }
}