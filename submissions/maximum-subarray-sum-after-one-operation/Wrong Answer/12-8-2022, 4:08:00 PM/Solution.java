// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation

class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = 0;
       
        if(len==0)
            return 0;
        
        if(len==1)
            return nums[0]*nums[0];
        
        
        int[][] dp = new int[len][2];
        
        dp[0][0] = nums[0];
        dp[0][1] = nums[0]*nums[0];
        
        
        for(int i=1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0]+nums[i], nums[i]);
            dp[i][1] = Math.max(dp[i-1][0]+nums[i]*nums[i], nums[i] + dp[i-1][1]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        
        return max;    
        
        
        // 定義dp[i] = 結尾第i個 element時的最大長度  XXXX, dp[i-1], dp[i] 
        // dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        
        
        // 下一步驟：with operation:
        // 定義dp[i][0] = 結尾第i個 element時的最大長度 without operation
        // 定義dp[i][1] = 結尾第i個 element時的最大長度 with operation
        // dp[i][1] = Math.max(dp[i-1][0] + nums[i]*nums[i] , dp[i-1][1]);
       
        
    }
}