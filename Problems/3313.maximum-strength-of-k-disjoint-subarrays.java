// https://leetcode.com/problems/maximum-strength-of-k-disjoint-subarrays

class Solution {
    public long maximumStrength(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n+1];
        System.arraycopy(nums, 0, arr, 1, n);
        nums = arr;

        long[][][] dp = new long[n+1][k+1][2];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=k; j++){
                Arrays.fill(dp[i][j], Long.MIN_VALUE/3);
            }
        }

        for (int i=0; i<=n; i++)
        {
            dp[i][0][0] = 0;
        }


        for (int i=1; i<=n; i++)
            for (int j=1; j<=k; j++)
            {
                if (j%2==0)
                {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], Math.max(dp[i-1][j-1][0], dp[i-1][j-1][1])) - (long)nums[i]*(k+1-j);                                        
                }
                else
                {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], Math.max(dp[i-1][j-1][0], dp[i-1][j-1][1])) + (long)nums[i]*(k+1-j);
                }                
            }
        
        return Math.max(dp[n][k][0], dp[n][k][1]);
                
    }
}