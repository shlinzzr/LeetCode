// https://leetcode.com/problems/minimum-cost-to-equalize-array

class Solution {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
       
        
        
        int max = 0;
        for(int n : nums)
             max= Math.max(max, n);
        
        int len = nums.length;
        int[] need = new int[len];
        
        for(int i=0; i<len; i++){
            need[i] = max - nums[i];
        }
        
        int M = (int) 1e9+7;
        long[] dp = new long[len+1]; // minimum cost to make the first i element zero
        dp[1] = need[0]*cost1 %M;
        
//         if(need[i-1]==0) dp[i] = dp[i-1]
//         if(need[i-1]>0)  dp[i] = Math.min( dp[i], dp[i-1]-cost1+ cost2);
        //  [0, 3], cost1 = 5, cost2 = 2
        // dp[1] = 0
        // dp[2] = 20 - 5 +2
        
        
        for(int i=2; i<=len; i++){
            dp[i]= dp[i-1];
            
            if(need[i-1]>0){
                
                dp[i] = Math.min(dp[i], (dp[i-1]-(cost1*need[i-1]%M)+ (cost2*need[i-1]%M))%M);
                
            }
        }
        
        return (int)dp[len]%M;
        
        
        
        
             
             
    }
}