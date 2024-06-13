// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        
        if(len%2==1)
            return nums[len/2]==target && (nums[len/2-1]==target || nums[len/2+1]==target);
        else
            return nums[len/2]==target && nums[len/2-1]==target;
    }
}