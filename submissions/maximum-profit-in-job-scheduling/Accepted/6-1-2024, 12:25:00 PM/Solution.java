// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;


        int[][] jobs = new int[len+1][];
        jobs[0] = new int[3];
        for(int i=0; i<len; i++){
            jobs[i+1] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a,b)-> a[1]-b[1]);

        int[] dp = new int[len+1];
        dp[0]=jobs[1][2];

        for(int i=1; i<=len; i++){
            dp[i] = Math.max(dp[i-1], jobs[i][2]);
            for(int j=i-1; j>0; j--){
                if(jobs[j][1]<=jobs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+jobs[i][2]);
                    break;
                }
            }
        }

        return dp[len];
        



        /*

        Task prev = list.get(0);
        int sum = 0;
        for(int i=1; i<len; i++){
            Task curr = list.get(i);

            if(prev.ed <= curr.st){
                sum += prev.p;
                prev = curr;
                continue;
            }

            if(curr.p<=prev.p){
                continue;
            }else{
                prev.p = curr.p;
                prev.ed = curr.ed;
            }
        }

        sum += prev.p;


        return sum;
*/

        
    }
}