// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        // https://leetcode.com/problems/longest-increasing-subsequence/discuss/2395527/3-Approaches%3A-Backtrack-DP-Binary-Search
        
        // https://www.youtube.com/watch?v=l2rCz7skAlk
        
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max=0;
        for(int i=0; i<nums.length;i++){
            
            for(int j=0; j<i; j++){
                
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);    
                }
            }
            
            max = Math.max(max, dp[i]);
            
        }
        
        return max;
        
    }
}