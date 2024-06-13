// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        
        int st =0, ed=len-1;

        int max =0;
        
        while(st<ed){
            
            if(height[st]<=height[ed]){
                st++;
            }else{
                ed--;
            }
            
            max = Math.max(max, Math.min(height[st], height[ed]) * (ed-st));
            
        }
        
        return max;
    }
}