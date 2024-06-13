// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int idx =0;
        
        boolean[] dp = new boolean[len];
        dp[0] = true;
        int max = Integer.MIN_VALUE;
        
        max = Math.max(max, nums[0]);
        
        for(int i=0; i<len; i++){
            
            if(i<=max){
                dp[i] = true;
                max = Math.max(max, i+nums[i]);
            }
//             for(int j=0; j<i; j++){
                
//                 if(dp[j]==true && j+nums[j]>=i){
//                     dp[i]=true;
//                     continue;
//                 }
//             }
            
        }
        
        return dp[len-1];
        
        
    }
}