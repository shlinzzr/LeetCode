// https://leetcode.com/problems/predict-the-winner

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        // recur
        int len = nums.length;
        
        return recur(nums , 0, len-1)>=0;
        
        
        
        
        // dp
        // int n = nums.length;
        // int[][] dp = new int[n][n];
        // for (int i = 0; i < n; i++) { dp[i][i] = nums[i]; }
        // for (int len = 1; len < n; len++) {
        //     for (int i = 0; i < n - len; i++) {
        //         int j = i + len;
        //         dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        //     }
        // }
        // return dp[0][n - 1] >= 0;
    }
    
    
    private int recur(int[] nums, int st, int ed){
        
        if(st==ed) return nums[st];
        
        return Math.max(nums[st]-recur(nums, st+1, ed)
                       ,nums[ed]-recur(nums, st, ed-1));
    }
}