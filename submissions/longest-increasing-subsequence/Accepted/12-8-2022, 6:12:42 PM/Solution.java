// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int res=0;
        
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, 1);
        // dp[i]定義為以i為最後一個element的時候 最長的LIS
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                
               if(nums[i]>nums[j]){
                   dp[i] = Math.max(dp[i], dp[j]+1);
               }
            }
            
            res = Math.max(res, dp[i]);
        }
        
        return res;
        
        
    }
}