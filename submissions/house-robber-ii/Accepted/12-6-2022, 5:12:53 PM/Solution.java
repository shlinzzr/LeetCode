// https://leetcode.com/problems/house-robber-ii

class Solution {

    public int rob(int[] nums) {
        
        int len = nums.length;
        if(nums.length==1)
            return nums[0];
        
        return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
        
    }
    
    private int helper(int[]nums, int st, int ed){
        
        int[] dp = new int[nums.length+1];
        
        if(st==0){
            dp[0]=0;
            dp[1]=nums[0];
        }else{
            dp[0]=0;    
            dp[1]=0;
            dp[2]=nums[1];
        }
        
        for(int i=st+1; i<=ed; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }
        return dp[ed+1];
        
    }
    
    // public int houseRob_1(int[] nums) {
    //     int len = nums.length;
    //     int[] dp = new int[len+1];
    //     dp[0]=0;
    //     dp[1]=nums[0];
    //     // dp[i+1] = max(nums[i]+dp[i-1], dp[i])
    //     for(int i=1; i<len; i++){
    //         dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
    //     }
    //     return dp[len];
    // }
    
    

}