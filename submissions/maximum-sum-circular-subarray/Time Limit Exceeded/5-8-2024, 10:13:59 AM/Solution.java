// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int len = nums.length;

        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            int sum = 0;
            for(int j=i; j<i+len; j++){
                sum += nums[j%len];
                max = Math.max(max, sum);
                if(sum<0){
                    sum=0;
                    i=j;
                    break;
                }
            }

            // i==0, max = 5
            // i==1, 
            // i==2, 
        }

        return max;
        
    }
}