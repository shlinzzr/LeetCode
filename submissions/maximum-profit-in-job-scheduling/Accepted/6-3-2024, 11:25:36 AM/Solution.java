// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int len = profit.length;
        int[][] jobs = new int[len][];
        for(int i=0; i<len; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b)-> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);

        int[] dp = new int[len+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i=1; i<=len; i++){

            int[] cur = jobs[i-1];

            dp[i] = Math.max(dp[i-1], cur[2]);

            for(int j=i-1; j>0; j--){
                if(jobs[j-1][1]<= cur[0]){
                    dp[i] = Math.max(dp[i-1], dp[j]+cur[2]);
                    break;
                }
            }
        }

        return dp[len];
        
    }
}