// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        
        int total=0, curMax=0, curMin=0, maxSum=nums[0], minSum=nums[0];
        
        for(int i=0; i<len; i++){
            curMax = Math.max(curMax+nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin+nums[i], nums[i]);
            minSum = Math.min(minSum, curMin);
            total+=nums[i];
        }
        
        
        return maxSum>0? Math.max(maxSum, total-minSum) : maxSum;
    }
}