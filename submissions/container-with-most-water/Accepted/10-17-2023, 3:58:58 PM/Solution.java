// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int st=0, ed=len-1;

        int max=0;

        while(st<ed){
            int left = height[st];
            int right = height[ed];

            max= Math.max(max, Math.min(left, right)*(ed-st));

            if(left<right){
                st++;
            }else 
                ed--;
        }

        return max;

    }
}