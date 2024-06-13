// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        
        int max = 0;
        
        int st=0, ed=len-1;
        
        while(st<ed){
            
            int vol = (ed-st) * Math.min(height[st], height[ed]);
            
            max = Math.max(max, vol);
            
            
            if(height[st]<=height[ed]){
                st++;
            }else{
                ed--;
            }
        }
        
        return max;
    }
}