// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        
        boolean[] dp = new boolean[len];
        dp[0] = true;
        
        int max = nums[0];
        
        for(int i=0; i<len; i++){
            
            if(i<=max){
                int next = i+nums[i];
                max = Math.max(max, next);
                dp[i] = true;
            }
        }
        
        return dp[len-1];
        
        
        
        
    }
}