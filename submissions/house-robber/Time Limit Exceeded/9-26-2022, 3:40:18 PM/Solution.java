// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        
        // recursive
        
        // rob(i) = Math.max(rob(i-1), rob(i-2)+ curr)
        
        return helper(nums, nums.length-1);
        
    }
    
    private int helper(int[] nums, int i){
        if (i < 0) {
            return 0;
        }
        
        int res = Math.max(helper(nums, i-2)+ nums[i], helper(nums, i-1));
        return res;
    }
}