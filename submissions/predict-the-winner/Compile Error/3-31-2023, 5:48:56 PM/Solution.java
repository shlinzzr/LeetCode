// https://leetcode.com/problems/predict-the-winner

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int st=0;
        int len=nums.length;
        int ed= len-1;
        
        while(st<ed){
            
            
            
            
            
            
            
        }
        
    }
    
    
    private int helper(int[]nums, int st, int ed, int curr){
        
        if(st<ed) return curr;
        
        return Math.max(helper(nums, st+1, ed, curr+nums[st]), helper(nums,st, ed-1, nums[ed]));
    }
}