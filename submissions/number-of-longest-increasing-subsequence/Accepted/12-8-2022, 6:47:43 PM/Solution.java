// https://leetcode.com/problems/number-of-longest-increasing-subsequence

class Solution {
    
    //幹拎 靠北難。 https://www.youtube.com/watch?v=ESUKmxtA5sY
    
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int res = 0;
        int max = 0;
        int[] dp =  new int[len];
        int[] cnt = new int[len];
        
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        
        for(int i = 0; i<len; i++){
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] == dp[j] + 1)
                        cnt[i] += cnt[j];
                    
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max == dp[i])
                res += cnt[i];
            
            if(max < dp[i]){
                max = dp[i];
                res = cnt[i];
            }
        }
        return res;
    }
}