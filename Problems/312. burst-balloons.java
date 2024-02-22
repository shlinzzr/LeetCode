// https://leetcode.com/problems/burst-balloons

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] arr = new int[n];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = 1;
        arr[n - 1] = 1;
        int[][] dp = new int[n][n];
        // do not include the first one and the last one
        // since they are both fake balloons added by ourselves and we can not burst
        // them

        for(int len=1; len<=nums.length; len++){
            for(int i=1; i+len-1<=nums.length; i++){

                int j = i+len-1;
                for(int k=i; k<=j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1]+ dp[k+1][j] + arr[i-1]*arr[k]*arr[j+1]);
                }
            }
        }
        return dp[1][nums.length];

        // for (int left = n - 2; left >= 1; left--) {
        //     for (int right = left; right <= n - 2; right++) {
        //         // find the last burst one in newNums[left]...newNums[right]
        //         for (int i = left; i <= right; i++) {
        //             // newNums[i] is the last burst one
        //             int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
        //             // recursively call left side and right side
        //             int remaining = dp[left][i - 1] + dp[i + 1][right];
        //             // update
        //             dp[left][right] = Math.max(remaining + gain, dp[left][right]);
        //         }
        //     }
        // }
        // burst newNums[1]...newNums[n-2], excluding the first one and the last one
        // return dp[1][n - 2];
    }
}