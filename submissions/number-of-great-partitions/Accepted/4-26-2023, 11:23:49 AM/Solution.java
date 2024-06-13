// https://leetcode.com/problems/number-of-great-partitions

class Solution {
    
    int M =(int)1e9+7;
    
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[][] dp = new long[1005][1005];
        
        long[] presum = new long[n];
        for(int i=0; i<n; i++){
            if(i==0)
                presum[0] = (long)nums[0];
            else
                presum[i] = (long)presum[i-1] + (long)nums[i];
        }
        
        if(presum[n-1]<k*2)
            return 0;
        
        
        
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
        
//         int ed = len;
//         for(int i = len-2; i>=0; i--){
//             if(presum[len-1] -presum[i]>=k ){
//                 ed=i+1;
//                 break;
//             }
                
//         }            
            
//         System.out.println(st + " " + ed) ;
//         if(st>=ed)
//             return 0;
        
//         return (int)Math.pow(2, (ed-st-1));
        
        
    }
}