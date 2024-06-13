// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        
        if(len==1)
            return true;
            
        
        
        int max =0;
        boolean[] dp = new boolean[len+1];
        
        dp[0]=true;
        dp[1]=true; 
        max = nums[0]+1;
        dp[2]=dp[1] && Math.max(max, nums[0]+1) > 1+1;
        
        for(int i=1; i<len; i++){
            
            dp[i+1] = (dp[i]&&nums[i-1]>0) || max>=i+1;
            
            if(dp[i+1])
                max = Math.max(max, i+1 + nums[i]);
            System.out.println(max);
            
        }
        
        return dp[len];
    }
}