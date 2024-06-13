// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        int[][] jobs = new int[len][3];
        
        for(int i=0; i<len; i++){
            int[] j = new int[]{startTime[i], endTime[i], profit[i]};
            jobs[i] = j;
        }
        
        // Arrays.sort(jobs, (a,b) -> a[1]==b[1]? b[2]-a[2]  : a[1]-b[1]);
        Arrays.sort(jobs, (a,b) ->  a[1]-b[1]);
            
        
        int dp[] = new int[len+1];
        dp[0] = jobs[0][2];
        for(int i=1; i<=len; i++){
            dp[i] = Math.max(jobs[i-1][2], dp[i-1]);
            
            for(int j=i-1; j>0; j--){
                if(jobs[j-1][1]<=jobs[i-1][0]){
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i-1][2]);
                    break;
                }
            }
        }
        
        // int max = Integer.MIN_VALUE;
        // for(int d : dp){
        //     max = Math.max(max, d);
        // }
        
        
        return dp[len];
        
        
    }
}