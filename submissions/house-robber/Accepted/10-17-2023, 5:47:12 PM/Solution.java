// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        // if(len==1) return nums[0];
        // if(len==2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[len+1];
        for(int i=1; i<=len; i++){
            dp[i] = Math.max(dp[i-1], nums[i-1] + (i>=3? dp[i-2] : 0 )) ;
        }

        return dp[len];

    }
}