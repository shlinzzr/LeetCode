// https://leetcode.com/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        if(nums.length==1)
            return nums[0];
        
        return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
        
    }
    
    public int rob(int[] Rob, int[] nums, int start, int end) {
        if(start == 0) {//in case of we rob house 0 to n-2, and it is the same as House rober question 1
            Rob[0] = nums[0];
            Rob[1] = Math.max(nums[0],nums[1]);
        }
        else //in case of we rob house 1 to n-1
            Rob[1] = nums[1];        
        //the same as House rober question 1
        for (int i=2; i<end; i++){
            Rob[i] = Math.max(Rob[i-2]+nums[i], Rob[i-1]);            
        }
        
        return Rob[end-1];
    }
    
    
    private int helper(int[]nums, int st, int ed){
        
        int[] dp = new int[ed+1];
        
        if(st==0){
            dp[0]=0;
            dp[1]=nums[0];
        }else{
            dp[0]=0;    
            dp[1]=0;
            dp[2]=nums[st];
        }
        
        for(int i=st==0? 1 : 2 ; i<ed; i++,st++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }
        
        return dp[ed];
        
    }
    
//      public int rob(int[] nums) {
//         int len = nums.length;
//         int[] dp = new int[len+1];
//         dp[0]=0;
//         dp[1]=nums[0];
        
//         // dp[i+1] = max(nums[i]+dp[i-1], dp[i])
        
//         for(int i=1; i<len; i++){
//             dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
//         }
//         return dp[len];
//     }
    
    
    
}