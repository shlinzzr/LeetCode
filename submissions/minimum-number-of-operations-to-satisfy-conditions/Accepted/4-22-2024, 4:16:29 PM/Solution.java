// https://leetcode.com/problems/minimum-number-of-operations-to-satisfy-conditions

class Solution {
    public int minimumOperations(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] dp = new int[w][10];
        for(int j=0; j<w; j++){
            int[] cnt = new int[10];
            for(int i = 0; i < h; i++) {
                cnt[grid[i][j]]++;
            }
            for(int k = 0; k < 10; k++) {
                dp[j][k] = h-cnt[k];
            }
        }

        int[][] dpp = new int[w][10];
        for(int k=0; k<10; k++) dpp[0][k] = dp[0][k];

        for(int j=1; j<w; j++) {
            for(int k = 0; k < 10; k++) {
                int min = 1000000;
                for(int q = 0; q < 10; q++) {
                    if(q!=k) min = Math.min(min, dpp[j-1][q]);
                }
                dpp[j][k] = min + dp[j][k];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int k=0; k<10; k++) ans = Math.min(ans, dpp[w-1][k]);
        
        return ans;
    }
}