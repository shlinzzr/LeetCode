// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {

        int len = nums.length;

        if(len==1) return true;


        int max = nums[0];

        boolean[] dp = new boolean[len+1];
        dp[0]=true;
        dp[1]=true;

        for(int i=1; i<=len; i++){
            if(i<=max) {
                max = Math.max(max, i+nums[i-1]);
                dp[i] = true;
            }
        }

        return dp[len];

        
    }
}