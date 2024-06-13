// https://leetcode.com/problems/house-robber

class Solution {
    
    int[] memo;
    
    public int rob(int[] nums) {
        
        // recursive + memo
        // rob(i) = Math.max(rob(i-1), rob(i-2)+ curr)
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        return helper(nums, nums.length-1);
        
    }
    
    private int helper(int[] nums, int i){
        if (i < 0) {
            return 0;
        }
        
        if(memo[i]>=0)
            return memo[i];
        
        
        int res = Math.max(helper(nums, i-2)+ nums[i], helper(nums, i-1));
        memo[i] = res;
        return res;
    }
}