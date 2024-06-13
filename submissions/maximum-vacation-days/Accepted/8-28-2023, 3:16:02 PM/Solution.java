// https://leetcode.com/problems/maximum-vacation-days

class Solution {
    
    //https://leetcode.com/problems/maximum-vacation-days/discuss/102655/Java-DFS(TLE)-and-DP-Solutions
    
    
//     int max = 0, N = 0, K = 0;
    
//     // DFS => TLE
    
//     public int maxVacationDays(int[][] flights, int[][] days) {
//         int len = flights.length; //2. n*n, non-sym
    
//         //3. k weeks, depart@monday  morning
        
//         // days:n*k,  days[i][j] : max vacation day in city i in week j
        
//         // A-> B : day count on B city
        
//         //1.  0~n-1 cities, init at 0 / monday
  
//         N = flights.length;
//         K = days[0].length;
//         dfs(flights, days, 0, 0, 0);
        
//         return max;
//     }
    
//     private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
//         if (week == K) {
//             max = Math.max(max, sum);
//             return;
//         }
        
//         for (int dest = 0; dest < N; dest++) {
//             if (curr == dest || f[curr][dest] == 1) { // curr==dest means stay at same city
//                 dfs(f, d, dest, week + 1, sum + d[dest][week]);
//             }
//         }
            
//     }
    
    // dp
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N]; //每個city的max vacation day
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        
        // days[j][i] : max day in city j in week i
        // dp[]
        
        // most k weeks, from 0~k-1 week
        for (int k = 0; k < K; k++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if ( i==j || flights[i][j] == 1) { //j==k means stay same city, flights[k][j]: fly from k to j city
                        
                        //當可以從i city飛去j city的時候
                        // city j的max = 前一天的i : dp[i] + j city當週的day: days[j][k]
                        temp[j] = Math.max(temp[j], dp[i] + days[j][k]);  // 前一天
                    }
                }
            }
            
            dp = temp;
        }
        
        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        
        return max;
    }
}
