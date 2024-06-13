// https://leetcode.com/problems/maximum-vacation-days

class Solution {
    
    int max = 0, N = 0, K = 0;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        int len = flights.length; //2. n*n, non-sym
    
        //3. k weeks, depart@monday  morning
        
        // days:n*k,  days[i][j] : max vacation day in city i in week j
        
        // A-> B : day count on B city
        
        //1.  0~n-1 cities, init at 0 / monday
  
        N = flights.length;
        K = days[0].length;
        dfs(flights, days, 0, 0, 0);
        
        return max;
    }
    
    private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
        if (week == K) {
            max = Math.max(max, sum);
            return;
        }
        
        for (int dest = 0; dest < N; dest++) {
            if (curr == dest || f[curr][dest] == 1) { // curr==dest means stay at same city
                dfs(f, d, dest, week + 1, sum + d[dest][week]);
            }
        }
            
    }
}