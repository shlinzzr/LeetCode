// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int len = nums.length;
        int[] copy = new int[len+len];
        System.arraycopy(nums, 0, copy, 0, len);
        System.arraycopy(nums, 0, copy, len, len);

        for(int n : copy){
            System.out.print(n + ",");
        }

        return maxSubArray(copy);
        
    }

     public int maxSubArray(int[] nums) {
        // kadane's algo
        
        int len = nums.length;
        
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