// https://leetcode.com/problems/minimum-cost-for-tickets

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int lastDay = days[len-1];
        int[] dp = new int[lastDay+1];   //dp[i] means up to i-th day the minimum cost of the tickets
        boolean[] isTravelDays = new boolean[lastDay + 1];
        // mark the travel days
        for(int d : days) 
            isTravelDays[d] = true;
    
        for(int i = 1; i <= lastDay; i++) {
            if(!isTravelDays[i]) { // no need to buy ticket if it is not a travel day
                dp[i] = dp[i - 1];
                continue;
            }
            // select which type of ticket to buy
            dp[i] = costs[0] + dp[i - 1]; // 1-day
            dp[i] = Math.min(costs[1]+dp[Math.max(i-7, 0)], dp[i]); // 7-day
            dp[i] = Math.min(costs[2]+dp[Math.max(i-30, 0)], dp[i]); // 30-day
        }
        return dp[lastDay];
        
        
    }
}