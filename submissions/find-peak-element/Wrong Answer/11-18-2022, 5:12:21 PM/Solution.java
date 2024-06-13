// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        
        
        for(int i=1; i<nums.length-1; i++){
            
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
                return i;
            
        }
        return -1;
    }
}