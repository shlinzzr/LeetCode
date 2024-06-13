// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        // 1. treeMap 最簡單 但tricky 解法很專一 無通用性
        // 2. dp 最套路的方式 最佳解
        // 3. 用binary search 找 previous 邊界條件不好想
        
        
        
        
        // treemap 126 ms, 8.96%
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
        
        /*
         *   dp array+bisearch 63ms, 49.86%
         */
        
        int n =len;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            int lo = 0, hi = i-1;
            while(lo < hi) {
                int m = hi- (hi - lo)/ 2;
                if (jobs[m][1] <= jobs[i][0]) { //找一個m的endTime  s.t 這個endTime<=目前的 stTime
                    lo = m;
                } else {
                    hi = m-1;
                }
            }
            
            // [ x x x ]  [ x x x i ] 
            //      m.ed<=i.st
            
            //再次確認 (jobs[lo][1] <= jobs[i][0])
            // if(jobs[lo][1] <= jobs[i][0])
            //     val = jobs[i][2]+dp[m-1];
            // else
            //     val = jobs[i][2];
            
            dp[i + 1] = Math.max(dp[i + 1], ((jobs[lo][1] <= jobs[i][0]) ? dp[lo + 1] : 0) + jobs[i][2]);
        }
        return dp[n];
        
        
    }
}