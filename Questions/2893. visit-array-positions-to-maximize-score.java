// https://leetcode.com/problems/visit-array-positions-to-maximize-score

class Solution {
    public long maxScore(int[] nums, int x) {
        
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(long[] d : dp){
            Arrays.fill(d, Long.MIN_VALUE/2);
        }
        
        if (nums[0]%2==0)
            dp[0][0] = nums[0];
        else
            dp[0][1] = nums[0];
        
        for (int i=1; i<n; i++)            
        {
            dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i][1], dp[i-1][1]);
            
            if (nums[i]%2==0)
            {                                
                dp[i][0] = Math.max(dp[i][0], dp[i-1][0] + nums[i]);
                dp[i][0] = Math.max(dp[i][0], dp[i-1][1] + nums[i] - x);
            }
            else
            {                
                dp[i][1] = Math.max(dp[i][1], dp[i-1][1] + nums[i]);
                dp[i][1] = Math.max(dp[i][1], dp[i-1][0] + nums[i] - x);
            }            
        }
        
        return Math.max(dp[n-1][0], dp[n-1][1]);
        
        
        
        
//         int len = nums.length;
        
//         long[][] dp = new long[len][2];
        
//         if(nums[0]%2==0){
//             dp[0][0] = nums[0];    
//         }else{
//             dp[0][1] = nums[0];
//         }
        
        
//         System.out.println(dp[0][0] + "  " + dp[0][1]);
//         System.out.println( );
//         System.out.println( );
//         for(int i=1; i<len; i++){
            
//             dp[i][0] = dp[i-1][0];
//             dp[i][1] = dp[i-1][1];
            
//             if(nums[i]%2==0){
//                 dp[i][0] = Math.max(dp[i][0], dp[i-1][0]+nums[i]);
//                 dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+nums[i]-x);
//             }else{
//                 dp[i][1] = Math.max(dp[i][1], dp[i-1][1]+nums[i]);
//                 dp[i][1] = Math.max(dp[i][1], dp[i-1][0]+nums[i]-x);
//             }
            
//             System.out.println(dp[i][0] + "  " + dp[i][1] + "   "  + nums[i]);
//         }
                                                 

//         return Math.max(dp[len-1][0], dp[len-1][1]);
        
       
    }
}