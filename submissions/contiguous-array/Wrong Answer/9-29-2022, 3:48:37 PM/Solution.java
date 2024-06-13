// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        
        int max = 0;
        
        int st =0;
        for(int ed=0; ed<nums.length-1; ed++){
            if((nums[ed]==0&&nums[ed+1]==1) || (nums[ed]==1&&nums[ed+1]==0)){
                // System.out.println(st + " " +ed);
                ed++;
                int len = ed-st+1;
                max = Math.max(max, len);
            }else{
                st=ed+1;
            }
        }
        
        return max;
    }
}