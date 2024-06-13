// https://leetcode.com/problems/number-of-great-partitions

class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int M = (int)1e9+7;
        
        int len = nums.length;
        long sum = 0;
        for(int n : nums){
            sum+=n;
        }
        
        if(sum<2*k)
            return 0;
        
        long[][] dp = new long[len+1][1005];
        dp[0][0] = 1;
        
        for(int i=1; i<=len; i++){
            
            for(int s=0; s<k; s++){
                
                dp[i][s] += dp[i-1][s];
                if(s-nums[i-1]>=0){
                    dp[i][s] += dp[i-1][s-nums[i-1]];
                }
                
                dp[i][s] %= M;
            }
        }
        
        long total=1;
        for(int i=0; i<len; i++){
            total = total * 2 % M;
        }
        
        long invalid= 0;
        for(int i=0; i<k; i++){
            invalid = (invalid + (long)dp[len][i]) % M;
        }

        return (int)((total-2*invalid +M) %M);
        
        
        
        
        
    }
}