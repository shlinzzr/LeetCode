// https://leetcode.com/problems/delete-and-earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums.length==1)
            return nums[0];
        
        Arrays.sort(nums);
        int len = nums.length;
        int idx =len-1;
        int n = nums[idx];
        while(idx>0 && n==nums[len-1]){
            idx--;
            n=nums[idx];
        }
        
        
        return Math.max(helper(nums, 0, idx), helper(nums, 0, len-1));
        
    }
    
    
    private int helper(int[] input, int st, int ed){
        
        int len = input.length;
        int[] nums = new int[len];
        System.arraycopy(input, 0, nums, 0, len);
        
        int[] dp = new int[len+1];
        
        if(ed==len-1)
            clear(nums, nums[len-1]);
        
        
        // [2,3,4]
        dp[0]=0;
        dp[1]=nums[ed];
        // dp[2] = max(dp[1], dp[0]+nums[len-2]);
        for(int i=st+1; i<=ed; i++){
            
            if(nums[ed-i]+1==nums[ed+1-i]){// if(nums[1]==nums[2])
                dp[i+1] = Math.max(dp[i], dp[i-1]+nums[ed-i]);   // dp[1] or dp[0]+nums[1] 
                
                if(dp[i-1]+nums[ed-i]>dp[i])
                    clear(nums, nums[ed-i]);
                
            }else{
                dp[i+1] += dp[i] + nums[ed-i];
                clear(nums, nums[ed-i]);
            }
            
        }
        // System.out.println(dp[ed+1]);
        
        return dp[ed+1];
        
        
    }
    
    
    private void clear(int[] nums, int n){
        
        for(int i=0; i<nums.length; i++){
            
            if(nums[i]==n+1 || nums[i]==n-1)
                nums[i]=0;
        }
    }
}