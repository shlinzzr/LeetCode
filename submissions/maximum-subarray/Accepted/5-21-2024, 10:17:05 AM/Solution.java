// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        // kadane's algo
        
        int len = nums.length;

        // int max = nums[0], cur = 0;
        // for(int n : nums){
        //     cur = Math.max(cur+n, n);
        //     max = Math.max(cur, max);
        // }

        // return max;

        
        int cur = 0;
        int max = nums[0];
        for(int n : nums){
            if(cur<0) cur=0;
            cur+=n;
            max = Math.max(max, cur);
        }
        
        return max;
       
        
        
        
    }
}