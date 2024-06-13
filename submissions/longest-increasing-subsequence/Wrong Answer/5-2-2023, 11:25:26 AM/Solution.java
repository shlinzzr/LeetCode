// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        
        for(int ed= 0; ed<len; ed++){
            for(int st=0; st<ed; st++){
                
                if(nums[ed]>nums[st])
                    dp[ed] = Math.max(dp[ed], dp[st]+1);
            }
        }
        
        
        
        
        
        return dp[len-1];
        
    }
}