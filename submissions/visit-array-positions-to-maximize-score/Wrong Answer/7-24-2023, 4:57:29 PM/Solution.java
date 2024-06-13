// https://leetcode.com/problems/visit-array-positions-to-maximize-score

class Solution {
    public long maxScore(int[] nums, int x) {
        
        int len = nums.length;
        
        long[][] dp = new long[len][2];
        
        if(nums[0]%2==0){
            dp[0][0] = nums[0];    
        }else{
            dp[0][1] = nums[0];
        }
        
        for(int i=1; i<len; i++){
            
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];
            
            if(nums[i]%2==0){
                dp[i][0] = Math.max(dp[i][0], dp[i-1][0]+nums[i]);
                dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+nums[i]-x);
            }else{
                dp[i][1] = Math.max(dp[i][1], dp[i-1][1]+nums[i]);
                dp[i][1] = Math.max(dp[i][1], dp[i-1][0]+nums[i]-x);
            }
            
        }
                                                 

        return Math.max(dp[len-1][0], dp[len-1][1]);
        
       
    }
}