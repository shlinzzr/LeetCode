// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int n:nums) 
            sum+=n;
        
        if(sum%2==1) 
            return false;
        
        sum/=2;
        
        boolean[] dp=new boolean [sum+1];
        dp[0]=true;
        for(int k:nums){
            for(int j=sum;j>=k;j--)
                dp[j]=dp[j]||dp[j-k];
        }
        return dp[sum];
    }
}