// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        
        int[] dp = new int[len+1];
        int max = nums[0]+1; //目前能走多遠
        
        for(int i=2; i<=len; i++){
            
            if(i<=max){
                max = Math.max(max, i+nums[i-1]);
                dp[i] = max;
            }
            
        }
        
        return dp[len]>=len;
        
        
    }
}