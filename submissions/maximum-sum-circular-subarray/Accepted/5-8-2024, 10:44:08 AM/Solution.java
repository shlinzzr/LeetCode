// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        // circular means that we have 2 cases
        // normal case : like leetcode 53.
        // presum + sufsum : i.e. : totalsum - minSum
        int len = nums.length;

        int minSum=Integer.MAX_VALUE;

        int maxSum = maxSubArray(nums);
        int totalSum = 0;

        int curmin = 0;
        for(int i=0; i<len; i++){
            totalSum += nums[i];
            
            curmin += nums[i];
            minSum = Math.min(minSum , curmin );
            if(curmin>0){
                curmin = 0;
            }
        }

        System.out.println(maxSum +" " + totalSum + " " + minSum);

        int res = Math.max(maxSum , totalSum-minSum==0 ? Integer.MIN_VALUE : totalSum-minSum);

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