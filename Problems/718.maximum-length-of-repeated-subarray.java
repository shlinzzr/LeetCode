// https://leetcode.com/problems/maximum-length-of-repeated-subarray

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j] = dp[i-1][j-1] + 1
        // 求 max dp[i][j];
        
        int m = nums1.length;
        int n = nums2.length;
        
        int[][] dp = new int[m+1][n+1];

        //bottom up
        int max=0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                max = Math.max(dp[i][j], max);
            }
        }
         return max;
        
        //top down
             
        // int max = 0;
        // int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // for (int i = nums1.length - 1; i >= 0; --i) {
        //     for (int j = nums2.length - 1; j >= 0; --j) {
        //         if (nums1[i] == nums2[j]) {
        //             dp[i][j] = dp[i+1][j+1] + 1;
        //             if (max < dp[i][j]) max = dp[i][j];
        //         }
        //     }
        // }
        // return max;
        
        
    }
}