// https://leetcode.com/problems/predict-the-winner

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        // recur https://www.youtube.com/watch?v=g5wLHFTodm0
        int len = nums.length;
        Integer[][] mem = new Integer[len][len];
        return recur(nums , 0, len-1, mem)>=0;
        
        
        
        
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
    
    
    private int recur(int[] nums, int st, int ed, Integer[][] mem){
        
        if(mem[st][ed]!=null){
            return mem[st][ed];
        }
        
        if(st==ed){
            mem[st][ed] = nums[st];
        } else{
            mem[st][ed] =  Math.max(nums[st]-recur(nums, st+1, ed, mem)
                                   ,nums[ed]-recur(nums, st, ed-1, mem));    
        }
        
        return mem[st][ed];
            
    }
}