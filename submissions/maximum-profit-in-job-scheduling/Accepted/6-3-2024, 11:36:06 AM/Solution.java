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

            

            // for(int j=i-1; j>0; j--){ //這可以改binary Search
            //     if(jobs[j-1][1]<= cur[0]){
            //         dp[i] = Math.max(dp[i-1], dp[j]+cur[2]);
            //         break;
            //     }
            // }

            int idx = findTheFirstPrevEndTimeSmallerThanCurrStartTime(i, jobs, cur[0]);
            if(jobs[idx][1]<=cur[0]){
                dp[i] = Math.max(dp[i-1], dp[idx+1] + cur[2]);
            }


        }

        return dp[len];
        
    }

    private int findTheFirstPrevEndTimeSmallerThanCurrStartTime(int dp_idx, int[][] jobs, int currStartTime){

        // the 1 - dpidx job
        // => job_id from 0 to dp_idx-1
        // find (dp_idx-1)'s prev  is dp_idx-2
        int st = 0;
        int ed = dp_idx-2;

        while(st<ed){ // 0, 1

            int mid = ed-(ed-st)/2; // 1

            if(jobs[mid][1]<=currStartTime){
                st = mid;
            }else {
                ed = mid-1;
            }
        }

        return st;


    }
}