// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        int sum = 0;
        for(int n : nums){
            sum+=n;
        }

        if(sum%2==1)
            return false;
        else
            sum/=2;
        
        boolean[][] dp = new boolean[len+1][sum+1];
        dp[0][0] = true; //組成0個num之sum=0 的result=true;

        for(int i=1; i<=len; i++){
            for(int j=0; j<=sum; j++){

                dp[i][j] = dp[i-1][j];
                if(j-nums[i-1]>=0 && dp[i-1][j-nums[i-1]]){
                    dp[i][j] = true;
                }
            }
        }

        return dp[len][sum];
    }
}