// https://leetcode.com/problems/delete-and-earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.sort(nums);
        
        dp[0]=0;
        dp[1]=nums[len-1];
        // dp[2] = max(dp[1], dp[0]+nums[len-2]);
        for(int i=1; i<len; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[len-i-1]);
        }
        
        return dp[len];
        
    }
}