// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            int sum = 0;
            int j=i;
            for(; j<i+len; j++){
                sum += nums[j%len];
                max = Math.max(max, sum);
                if(sum<0){
                    sum=0;
                    i=j;
                    break;
                }

            }

            if(j==i+len-1) i=j;

        }

        return max;
        
    }
}