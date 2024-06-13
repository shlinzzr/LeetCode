// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        
        int st =0, ed=len-1;
        
        int max = 0;
        while(st<ed){
            
            int curr = (ed-st) * Math.min(height[st], height[ed]);
            
            // System.out.println(st + " " + ed + " " + curr);
            
            max = Math.max(max, curr);
            
            if(height[st]<height[ed])
                st++;
            else 
                ed--;
            
            
        }
        
        return max;
    }
}