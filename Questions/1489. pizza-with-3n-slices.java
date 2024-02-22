// https://leetcode.com/problems/pizza-with-3n-slices

class Solution {

    public int maxSizeSlices(int[] slices) {
        // like the house robber ii
        //https://www.youtube.com/watch?v=Pkip_mJhiFk

        int n = slices.length;

        return Math.max(solve(1, n-1, n/3, slices), solve(2, n, n/3, slices));

    }

    private int solve(int st, int ed, int k, int[] slices){

        int len = slices.length;

        int[][] dp0 = new int[ed+1][k+1];
        int[][] dp1 = new int[ed+1][k+1];

        dp0[st][0] =0;
        dp1[st][1] = slices[st-1];

        for(int i=st; i<=ed; i++){
            for(int j=1; j<=Math.min(k, i-st+1); j++){
                dp0[i][j] = Math.max(dp1[i-1][j], dp0[i-1][j]);
                dp1[i][j] = dp0[i-1][j-1] + slices[i-1];
            }
        }

        return Math.max(dp0[ed][k], dp1[ed][k]);

    }

}