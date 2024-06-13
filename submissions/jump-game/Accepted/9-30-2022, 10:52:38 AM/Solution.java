// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int targetIdx = nums.length-1;
        
        // dp[i] = 目前能走到最遠idx
        // dp[i+1] = Max(dp[i], i+nums[i])
        
        
        // dp[i] = 能否走來idx = i？ === 走來[i]的數量==0?
        // dp[0] =1;
        // dp[1] = dp[0] >1?
        // dp[2] = dp
        // dp[i+1] = dp[i]>1?
        // dp[i+n] = dp[i] > n?
        
        
        int max=0;
        for(int i=0; i<nums.length-1; i++){
            max = Math.max(nums[i]+i, max);
            if(i==max)
                return false;
            
        }
        
        return true;
        
    }
}