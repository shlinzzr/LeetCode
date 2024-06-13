// https://leetcode.com/problems/pizza-with-3n-slices

class Solution {
    public int maxSizeSlices(int[] slices) {
        // like the house robber ii

        int len = slices.length;
        if(len==1) return slices[0];
        if(len==2) return Math.max(slices[0], slices[1]);
        if(len==3) return Math.max(slices[0], Math.max(slices[1], slices[2]));



        int[] dp = new int[len+1];

        int max= 0 ;
        // choose [0, len-3]
        for(int i=1; i<=len-2; i++){
            dp[i] = Math.max(Math.max(dp[i-1], i<2 ? 0 : dp[i-2]), i<3? 0 : dp[i-3] + slices[i-1]);
        }
        max = dp[len-2];

        dp[1] = 0;
        for(int i=2; i<=len-1; i++){
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]), i<3? 0 : dp[i-3] + slices[i-1]);
        }
        max = Math.max(max, dp[len-1]);


        dp[1]=0;
        dp[2]=0;
        for(int i=3; i<=len; i++){
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]), dp[i-3] + slices[i-1]);
        }

        max = Math.max(max, dp[len]);

        return max;

    }
}