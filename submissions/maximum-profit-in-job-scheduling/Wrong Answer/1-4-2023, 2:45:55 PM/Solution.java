// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        
        
        int timeMax =0;
        Map<Integer, Integer> endMap = new HashMap<>(); // timeval, idx
        for(int i=0; i<len; i++){
            endMap.put(endTime[i], i);
            timeMax = Math.max(timeMax, endTime[i]);
        }
        
        int[] dp = new int[timeMax+1];
        
        
        for(int t=1; t<=timeMax ; t++){
            
            if(endMap.containsKey(t)){
                // System.out.println("t="+t + " dp[t-1]=" + dp[t-1] + " profit=" + profit[endMap.get(t)] + " dp[startTime]=" +  dp[startTime[endMap.get(t)]] );
                
                dp[t] = Math.max(dp[t-1], profit[endMap.get(t)] + dp[startTime[endMap.get(t)]]);
            }
        }
        
        return dp[timeMax];
        
    }
}