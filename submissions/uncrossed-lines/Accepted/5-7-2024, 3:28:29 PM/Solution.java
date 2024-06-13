// https://leetcode.com/problems/uncrossed-lines

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m+1][n+1];

        /*
               "" 1 4 2
            ""  0 0 0 0
             1  0 1 1 1
             2  0 1 1 2
             4  0 1 2 2
        */

        // for(int i=0; i<=m; i++){
        //     dp[i][0] = i;
        // }

        // for(int j=0; j<=n; j++){
        //     dp[0][j] = j;
        // }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{

                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    dp[i][j] = Math.max(up, left);
                }
            }
        }

        return dp[m][n];
    }
}