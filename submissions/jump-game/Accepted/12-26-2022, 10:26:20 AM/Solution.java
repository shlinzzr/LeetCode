// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int idx =0;
        
        boolean[] dp = new boolean[len];
        dp[0] = true;
        
        for(int i=0; i<len; i++){
            
            for(int j=0; j<i; j++){
                
                if(dp[j]==true && j+nums[j]>=i){
                    dp[i]=true;
                    continue;
                }
            }
            
        }
        
        return dp[len-1];
        
        
    }
}