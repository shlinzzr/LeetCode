// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        // circular means that we have 2 cases:
        // 1. normal case : like leetcode 53.
        // 2. presum + sufsum case :  i.e.  sumAll - minSubArray
        int len = nums.length;

        int minSum=Integer.MAX_VALUE;
        int maxSum = maxSubArray(nums); //leetcode 53 : kadane's algo
        int sumAll = 0;
        int curmin = 0;

        //找minSubArray
        for(int i=0; i<len; i++){
            sumAll += nums[i];
            
            curmin += nums[i];
            minSum = Math.min(minSum , curmin );
            if(curmin>0){
                curmin = 0;
            }
        }


        int res = Math.max(maxSum , sumAll-minSum==0 ? Integer.MIN_VALUE : sumAll-minSum);

        return res;




    }

     public int maxSubArray(int[] nums) {
        // leetcode 53
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