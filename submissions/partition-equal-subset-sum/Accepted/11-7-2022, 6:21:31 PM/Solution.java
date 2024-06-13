// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int n:nums) 
            sum+=n;
        
        if(sum%2==1) 
            return false;
        
        sum/=2;
        
        boolean[] dp = new boolean[sum+1];
        
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        
        return dp[sum];
    }
}