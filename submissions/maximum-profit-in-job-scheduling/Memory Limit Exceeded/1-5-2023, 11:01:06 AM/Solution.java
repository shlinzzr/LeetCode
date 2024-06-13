// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        
        
        int timeMax =0;
        Map<Integer, List<Integer>> endMap = new HashMap<>(); // timeval, idx
        for(int i=0; i<len; i++){
            List<Integer> list = endMap.get(endTime[i]);
            if(list==null){
                list = new ArrayList<>();
            }
            list.add(i);
            endMap.put(endTime[i], list);    
            
            timeMax = Math.max(timeMax, endTime[i]);
        }
        
        int[] dp = new int[timeMax+1];
        
        
        for(int t=1; t<=timeMax ; t++){
            
            if(endMap.containsKey(t)){
                
                
                
                List<Integer> list = endMap.get(t);

                dp[t] = Math.max(dp[t-1], dp[t]);
                
                for(int l=0; l<list.size(); l++){
                    
                    // System.out.println("t="+t + " dp[t-1]=" + dp[t-1] + " profit[" + list.get(l) + "]=" + profit[list.get(l)] + " +dp[" + startTime[list.get(l)] + "]=" +  dp[startTime[list.get(l)]] );
                    
                    dp[t] = Math.max(dp[t], profit[list.get(l)] + dp[startTime[list.get(l)]]);    
                }
                
                
            }else{
                dp[t] = dp[t-1];
                  // System.out.println("dp["+t + "]= " +  dp[t]);
                
            }
        }
        
        return dp[timeMax];
        
    }
}