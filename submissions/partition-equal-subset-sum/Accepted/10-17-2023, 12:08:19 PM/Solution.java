// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        
        // sol :  huifeng我大哥 https://www.youtube.com/watch?v=JIiDb2iPW40
        // 背包問題
        // 找定義 : dp[i][s] 找到first i 個element 的sum = true;
        
        // 找遞歸   1. dp[i][s] = dp[i-1][s]; 前i-1個可組成s的話, 前i必定也可組成s
        //         
        // X X X X X i
        //         2. dp[i][s] = dp[i-1][s-nums[i]]
        //
        // ==> dp[i][s] = dp[i-1][s] || (s>=nums[i] && dp[i-1][s-nums[i]])
        
        
        int sum=0;
        for(int n:nums) 
            sum+=n;
        
         if(sum%2==1) 
            return false;
        
        int len = nums.length;
        boolean[][] dp = new boolean[len+1][sum];
        dp[0][0]=true;
        
        for(int i=1; i<=len; i++){
            for(int s=0; s<=sum/2; s++){
                dp[i][s] = dp[i-1][s] || (s>=nums[i-1] && dp[i-1][s-nums[i-1]]);
                
            }
        }
        
        return dp[len][sum/2];
        
        
       /*.  sol 2 
        int sum=0;
        for(int n:nums) 
            sum+=n;
        
        if(sum%2==1) 
            return false;
        
        sum/=2; //轉化成找到一種方法加起來＝sum/2
        
        boolean[] dp = new boolean[sum+1];
        
        Arrays.fill(dp, false);
        dp[0] = true; // 組成sum=0方法必為true
        for (int num : nums) {
            for (int i = num; i<=sum; i++) {
                dp[i] = dp[i] || dp[i-num];   // dp[num] = dp[num] || dp[0]
            }
        }
        
        return dp[sum];*/
    }
}