// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] jobs = new int[len][3];
        for(int i=0; i<len; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a,b) -> (a[1]-b[1]));
        
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         map.put(0,0);
        
//         for(int i=0; i<len; i++){
//             int cur = map.floorEntry(jobs[i][0]).getValue() + jobs[i][2];
//             if(cur>map.lastEntry().getValue()){
//                 map.put(jobs[i][1], cur);
//             }
//         }
        
//         return map.lastEntry().getValue();
        int n =len;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            int lo = 0, hi = i;
            while(lo < hi - 1) {
                int m = lo + (hi - lo)/ 2;
                if (jobs[m][1] <= jobs[i][0]) {
                    lo = m;
                } else {
                    hi = m;
                }
            }
            dp[i + 1] = Math.max(dp[i + 1], ((jobs[lo][1] <= jobs[i][0]) ? dp[lo + 1] : 0) + jobs[i][2]);
        }
        return dp[n];
        
        
    }
}