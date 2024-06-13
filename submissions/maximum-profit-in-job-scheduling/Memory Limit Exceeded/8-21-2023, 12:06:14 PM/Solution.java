// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
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
        
    }
}