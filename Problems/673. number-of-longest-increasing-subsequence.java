// https://leetcode.com/problems/number-of-longest-increasing-subsequence

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        
        int[] dp = new int[len+1]; // the lis at with char num
        Arrays.fill(dp, 1);
        dp[0]=0;
        
        
        int[] times = new int[len+1];
        Arrays.fill(times, 1);
        
        
        for(int i=1; i<=len; i++){
            for(int j=1; j<i; j++){
                
                // System.out.println ("i="+i + " n[i-1]=" +nums[i-1] + " n[j-1]=" + nums[j-1] );
                if(nums[i-1]<=nums[j-1])
                   continue;
                   
                // as-is 只算最長lis時候的code
                // dp[i] = Math.max(dp[i], dp[j]+1);
                // System.out.println(nums[i-1] + " " + nums[j-1] + " dp[i]=" + dp[i]);
                
                // now: 為了計算有幾個 增加times 
                if(dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    times[i] = times[j];
                    
                }else if(dp[j]+1==dp[i]){
                    times[i] += times[j];
                }
                   
            }
        }
        
        
        // as-is
        // return dp[len];
        
        
        // now 
        int maxLen = 0;
        int res = 0 ;
        for(int i=0; i<=len; i++){
            if(dp[i]>maxLen){
                maxLen = dp[i];
                res = times[i];
            }else if(dp[i]==maxLen){
                res += times[i];
            }
        }
        
        return res;
        
        
        
    }
}