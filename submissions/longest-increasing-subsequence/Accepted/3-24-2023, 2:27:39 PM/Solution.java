// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0]=1;
        for(int i=1; i<len;i++){
            
            dp[i]=1;
            for(int j=0; j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            
        }
        
        int res = 0;
        for(int n : dp){
            res = Math.max(res, n);
        }
        return res;
    }
}