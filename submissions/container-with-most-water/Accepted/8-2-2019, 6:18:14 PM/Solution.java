// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int h0 = height[0];
        int h1 = height[1];
        int w = h0 < h1 ? h0 : h1;
        int max = w*1;
        
        
        for(int i=0; i<height.length; i++){
            
            for(int j=i+1; j<height.length; j++){
                int wi = height[i];
                int wj = height[j];
                int wall = wi < wj ? wi : wj;
                
                int con = wall *(j-i);
                if(con>max) max = con;
                
                
            }
                
        }
        
        return max;
        
        
    }
}