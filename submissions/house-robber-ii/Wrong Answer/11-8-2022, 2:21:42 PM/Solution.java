// https://leetcode.com/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        if(nums.length==1)
            return nums[0];
        
        return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
        
    }
    
    private int helper(int[]nums, int st, int ed){
        
        int len = nums.length;
        len=ed;
        int[] dp = new int[len+1];
        
        dp[0]=0;
        dp[1]=nums[0];
        
        for(int i=1;i<len; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }
        
        return dp[len];
        
    }
    
}