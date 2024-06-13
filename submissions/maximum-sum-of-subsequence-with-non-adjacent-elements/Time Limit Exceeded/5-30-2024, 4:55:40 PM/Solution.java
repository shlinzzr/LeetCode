// https://leetcode.com/problems/maximum-sum-of-subsequence-with-non-adjacent-elements

class Solution {
   private static final int MOD = 1000000007;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
         int n = nums.length;
       
        long[] dp = new long[n];

        dp[0] = Math.max(0, nums[0]);
        if (n > 1) {
            dp[1] = Math.max(dp[0], nums[1]);
        }
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }


        long sum = 0;
        for (int[] q : queries) {
            int pos = q[0];
            int value = q[1];
            nums[pos] = value;

            if (pos == 0) {
                dp[0] = Math.max(0, nums[0]);
                if (n > 1) {
                    dp[1] = Math.max(dp[0], nums[1]);
                }
            } else if (pos == 1) {
                dp[1] = Math.max(dp[0], nums[1]);
            }
            for (int i = Math.max(2, pos); i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            sum = (sum + dp[n - 1]) % MOD;
        }

        return (int) sum;
    }
}