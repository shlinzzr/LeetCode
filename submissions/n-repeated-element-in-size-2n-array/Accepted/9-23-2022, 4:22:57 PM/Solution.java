// https://leetcode.com/problems/n-repeated-element-in-size-2n-array

class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        
        if(nums[0]==nums[nums.length/2-1])
            return nums[0];
        
        if(nums[nums.length-1]==nums[nums.length/2])
            return nums[nums.length-1];
        
        else
        
        return nums[nums.length/2];
    }
}