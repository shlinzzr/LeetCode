// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        // kadane's algo
        
        int len = nums.length;

        int maxSum = 0 , curMax = 0;
        for(int n : nums){
            curMax = Math.max(curMax+n, n);
            maxSum = Math.max(curMax, maxSum);
        }

        return maxSum;

        
        // int cur = 0;
        // int max = nums[0];
        // for(int n : nums){
        //     if(cur<0) cur=0;
        //     cur+=n;
        //     max = Math.max(max, cur);
        // }
        
        // return max;
       
        
        
        
    }
}