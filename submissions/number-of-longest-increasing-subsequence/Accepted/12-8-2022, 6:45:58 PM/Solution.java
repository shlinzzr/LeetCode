// https://leetcode.com/problems/number-of-longest-increasing-subsequence

class Solution {
//     public int findNumberOfLIS(int[] nums) {
        
//         int max=0;
        
//         int len = nums.length;
        
//         int[] dp = new int[len];
//         int[] cnt = new int[len];
//         Arrays.fill(dp, 1);
        
//         for(int i=0; i<len; i++){
//             for(int j=0; j<i; j++){
                
//                 if(nums[i]>nums[j]){
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                 }
//             }
            
//             max = Math.max(max,dp[i]);
            
//         }
        
        
//         int cnt =0; 
//         for(int d : dp){
//             System.out.println(d);
//             if(d==max)
//                 cnt++;
//         }
        
//         return cnt;
        
//     }
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