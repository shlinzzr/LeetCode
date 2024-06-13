// https://leetcode.com/problems/container-with-most-water

class Solution {
//.    public int maxArea(int[] height) {
//         int max = 0;
//         for(int i=0; i<height.length-1; i++){
//             for(int j=i+1; j<height.length; j++){
//                 int vol = Math.min(height[i], height[j])*(j-i);
//                 max = Math.max(max, vol);
//             }
//         }
        
//         return max;
//     }
    
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
    
}