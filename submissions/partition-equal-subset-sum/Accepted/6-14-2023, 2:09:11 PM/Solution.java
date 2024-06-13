// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        
        int sum =0;
        
        for(int n : nums){
            sum+=n;
        }
        
        if(sum%2==1)
            return false;
        
        sum/=2;
        
        boolean[][] dp = new boolean[len+1][sum+1];
        dp[0][0] = true;
        
        for(int i=1; i<=len; i++){
            
            for(int s=0; s<=sum; s++){
                dp[i][s] = dp[i-1][s] || (s-nums[i-1]>=0 && dp[i-1][s-nums[i-1]]); 
            }
        }
        
        return dp[len][sum];
    }
}