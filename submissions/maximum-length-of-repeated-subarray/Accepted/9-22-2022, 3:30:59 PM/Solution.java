// https://leetcode.com/problems/maximum-length-of-repeated-subarray

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j] = dp[i-1][j-1] + 1
        // 求 max dp[i][j];
        
        //bottom up
        // int[][] dp = new int[nums1.length][nums2.length];
//         int max=0;
//         for(int i=0; i<nums1.length; i++){
//             for(int j=0; j<nums2.length; j++){
                
//                 if(nums1[i]==nums2[j]){
//                     if(i>0 && j>0){
//                         dp[i][j]=dp[i-1][j-1]+1;
//                     }else{
//                         dp[i][j]=1;
//                     }
//                 }
//                 max = Math.max(dp[i][j], max);
//             }
//         }
         // return max;
        
        //top down
             
        int max = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; --i) {
            for (int j = nums2.length - 1; j >= 0; --j) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                    if (max < dp[i][j]) max = dp[i][j];
                }
            }
        }
        return max;
        
        
    }
}