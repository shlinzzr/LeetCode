// https://leetcode.com/problems/campus-bikes-ii

class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int len = bikes.length;
        int[] dp = new int[(1<<len)];
        return dfs(workers, 0, bikes, 0, dp);
    }

    private int dfs(int[][] workers, int i, int[][] bikes, int state, int[] dp){
        if(i>=workers.length){
            return 0;
        }

        if(dp[state]!=0) return dp[state];

        int min = Integer.MAX_VALUE;

        for(int j=0; j<bikes.length; j++){
            if((state & (1<<j)) == 0){

                int[] a = workers[i];
                int[] b = bikes[j];

                int newState = state | (1<<j);
                min = Math.min(min , getDis(a, b) + dfs(workers, i+1, bikes, newState, dp));
            }
        }

        dp[state] = min;

        return min;
    }

    private int getDis(int[] a, int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}