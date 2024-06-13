// https://leetcode.com/problems/number-of-great-partitions

class Solution {
    
    //   // https://www.youtube.com/watch?v=V7wdVxiPFCU
    
    
    int M =(int)1e9+7;
    
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        long[] presum = new long[n];
        for(int i=0; i<n; i++){
            if(i==0)
                presum[0] = (long)nums[0];
            else
                presum[i] = (long)presum[i-1] + (long)nums[i];
        }
        
        
        if(presum[n-1]<k*2)
            return 0;
        
        
        long[][] dp = new long[1005][1005];
        dp[0][0] = 1;
        
        for (int i=1; i<=n; i++)
            for (int s = 0; s<k; s++)
            {                
                dp[i][s] += dp[i-1][s];
                if (s>=nums[i-1])
                    dp[i][s] += dp[i-1][s-nums[i-1]];
                dp[i][s] %= M;
            }
        
        long total = 1;
        for (int i=1; i<=n; i++)
            total = total * 2 % M;
        
        long invalid = 0;
        for (int s=0; s<k; s++)
            invalid = (invalid + dp[n][s]) % M;
        
        return (int)((total - invalid - invalid + M) % M);        
        
    }
}