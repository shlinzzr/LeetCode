// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        // 2023/8/21 Summary :
        // 1. treeMap 最簡單 但tricky 解法很專一 無通用性
        // 2. dp 最套路的方式 最佳解
        // 3. 用binary search 找 previous 邊界條件不好想

        // solution dp:
        int len = startTime.length;

        int[][] jobs = new int[len+1][3];  // pre process offset
        for(int i=0; i<len; i++){
            jobs[i+1] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a,b) ->  a[1]-b[1]);
        
        int dp[] = new int[len+1]; // 做到第i筆job時的 max profit
        dp[0] = jobs[1][2]; // 初始值 就是第1筆job的profit
        
        for(int i=1; i<=len; i++){
            dp[i] = Math.max( dp[i-1], jobs[i][2]);   //每次先跟之前比
            
            for(int j=i-1; j>0; j--){ //由後往前找第一個
                if(jobs[j][1]<=jobs[i][0]){ //檢查之前的job, 如果之前的edTime <= 現在的 stTime
                    
                    dp[i] = Math.max(dp[i], dp[j]/*當時max profit*/ + jobs[i][2]/*這次job的profit*/);
                    break;
                }
            }
        }
        return dp[len];
  
        
        
/*
        // follow 2830 套路 => Memory Exceeded , dp宣告太1e9太大
        int len = startTime.length;
        
        int max= 0 ;
        for(int i=0; i<len; i++){
            max = Math.max(max, endTime[i]);
        }
        
        int[] dp = new int[max+1];
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.putIfAbsent(endTime[i], new ArrayList<>());
            map.get(endTime[i]).add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        
        for(int i=1; i<=max; i++){
            
            dp[i] = dp[i-1];
            for(int[] arr : map.getOrDefault(i, new ArrayList<>())){
                dp[i] = Math.max(dp[i], dp[arr[0]] + arr[2]);
            }
        }
        
        return dp[max];
        */
        
        
        
        
        
//         // treemap 126 ms, 8.96%
//         int len = startTime.length;
//         int[][] jobs = new int[len][3];
//         for(int i=0; i<len; i++){
//             jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
//         }
//         Arrays.sort(jobs, (a,b) -> (a[1]-b[1]));
        
// //         TreeMap<Integer, Integer> map = new TreeMap<>();
// //         map.put(0,0);
// //         for(int i=0; i<len; i++){
// //             int cur = map.floorEntry(jobs[i][0]).getValue() + jobs[i][2];
// //             if(cur>map.lastEntry().getValue()){
// //                 map.put(jobs[i][1], cur);
// //             }
// //         }
// //         return map.lastEntry().getValue();
        
//         /*
//          *   dp array+bisearch 63ms, 49.86%
//          */
        
//         int n =len;
//         int[] dp = new int[n + 1];
//         for (int i = 0; i < n; i++) {
//             dp[i + 1] = Math.max(dp[i], dp[i + 1]);
//             int lo = 0, hi = i-1;
//             while(lo < hi) {
//                 int m = hi- (hi - lo)/ 2;
//                 if (jobs[m][1] <= jobs[i][0]) { //找一個m的endTime  s.t 這個endTime<=目前的 stTime
//                     lo = m;
//                 } else {
//                     hi = m-1;
//                 }
//             }
            
//             // [ x x x ]  [ x x x i ] 
//             //      m.ed<=i.st
            
//             //需再次確認 (jobs[lo][1] <= jobs[i][0])
//             // if(jobs[lo][1] <= jobs[i][0])
//             //     val = jobs[i][2]+dp[m-1];
//             // else
//             //     val = jobs[i][2];
//             // dp[i+1] = Math.max(dp[i+1], val);
            
//             dp[i + 1] = Math.max(dp[i + 1], ((jobs[lo][1] <= jobs[i][0]) ? dp[lo + 1] : 0) + jobs[i][2]);
//         }
//         return dp[n];
        
        
    }
}