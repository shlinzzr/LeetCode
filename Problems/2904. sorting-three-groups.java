// https://leetcode.com/problems/sorting-three-groups

class Solution {
    public int minimumOperations(List<Integer> nums) {
        // nums = [2,1,3,2,1]
        // 1 : 1 4 0 2 3
        // 2 : 
        // 3 : 
        
        int len = nums.size();
      
        int[][] dp = new int[len+1][4]; // dp[i][j] 走到第i個數字的時候 最高位為j的最小cost
        
        // dp[i][1] = dp[i-1][1] + nums[i]!=1
        // dp[i][2] = min(dp[i-1][1], dp[i-1][2]) + nums[i]!=2
        // dp[i][3] = min(dp[i-1][1], dp[i-1][2], dp[i-1][3]) + nums[i]!=3
        
        
        for(int i=1; i<=len; i++){
         
            dp[i][1] = dp[i-1][1] + (nums.get(i-1)!=1? 1 : 0);
            dp[i][2] = Math.min( dp[i-1][1], dp[i-1][2]) + (nums.get(i-1)!=2? 1 : 0);
            dp[i][3] = Math.min( dp[i-1][1], Math.min(dp[i-1][2], dp[i-1][3])) + (nums.get(i-1)!=3? 1 : 0);
            
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=3; i++){
            
            min = Math.min(min, dp[len][i]);
        }
        
        return min;
        
        
    }
}