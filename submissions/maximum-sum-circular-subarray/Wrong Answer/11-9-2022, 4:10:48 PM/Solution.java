// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int noncir_sum = getMaxSum(nums);
        
        
        int len = nums.length;
        int min =Integer.MAX_VALUE;
        int sum = 0;
        
        int total=0;
        for(int i=0; i<len; i++){
            
            total+=nums[i];
            nums[i] = -nums[i];
        }
        
        int circularSum = total-getMaxSum(nums);
        
        return Math.max(noncir_sum, circularSum);
        
    }
    
    private int getMaxSum(int[] nums){
        int len = nums.length;
        int max =Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<len; i++){
            
            if(sum<0){
                sum=0;
            }
            
            sum+=nums[i];
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
}