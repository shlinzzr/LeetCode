// https://leetcode.com/problems/number-of-longest-increasing-subsequence

class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        // huifeng :  https://www.youtube.com/watch?v=ESUKmxtA5sY
        
        
        int len = nums.length;
        
        int[] times = new int[len];
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(times, 1);
        
        
        for(int ed=0; ed<len; ed++){
            for(int st=0; st<ed; st++){
                
                if(nums[ed]<=nums[st])
                    continue;
                
                if(dp[st]+1>dp[ed]){
                    dp[ed] = dp[st]+1;
                    times[ed] = times[st];
                    
                }else if(dp[st]+1 == dp[ed]){
                    times[ed] += times[st];
                }
                
            }
        }
    
        int max = 0;
        int res = 0;
        
        for(int i=0; i<len; i++){
            
            if(dp[i]>max){
                max = dp[i];
                res = times[i];
                
            }else if(dp[i]==max){
                res += times[i];
            }
        }

        
        
        
        return res;
        
        
    }
}