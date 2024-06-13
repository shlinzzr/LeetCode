// https://leetcode.com/problems/house-robber

// class Solution {
//     public int rob(int[] nums) {
        
//         if(nums.length==1)
//             return nums[0];
        
//         int odd=nums[0], even=nums[1];
        
   
        
//         for(int i=2; i<nums.length; i+=2){
            
//             if(i+1>=nums.length){
//                 odd += nums[i];
//                 even+=nums[i];
                
//             }else  if(odd+nums[i+1] > odd+nums[i] &&  odd+nums[i+1] > even +nums[i+1] ){
//                odd += nums[i+1];
//                even+=nums[i];
//                 i++;
                
//             }else{
//                 odd+=nums[i];
//                 even+=nums[i+1];
//             }
            
          
//         }
        
//         return even>odd? even : odd;
//     }
// }

 class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];
        dp[0]=nums[0];
        if(n==1){
            return nums[0];
        }
        
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        
        return dp[n-1];

    }
}