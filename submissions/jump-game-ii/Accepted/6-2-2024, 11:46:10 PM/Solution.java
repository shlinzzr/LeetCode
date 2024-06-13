// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {

        int len = nums.length;

        int[] dp =new int[len+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for(int i=1; i<=len; i++){
            int step = nums[i-1];
            for(int j=1; j<=step && i+j<=len; j++){
                dp[i+j] = Math.min(dp[i+j], 1+dp[i]);
            }
        }

        return dp[len];


        
    }
}