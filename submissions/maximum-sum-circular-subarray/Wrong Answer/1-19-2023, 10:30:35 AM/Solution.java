// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        
        int max = Integer.MIN_VALUE;
        
        int sum=0;
        int st=0;
        for(int i=0; i<2*len; i++){
            int idx = i%len;
            
            if(sum<0){
                sum=0;
                st=idx;
            }
            
            sum+=nums[idx];
            
            
            max = Math.max(max, sum);
            
            if(idx==st-1){
                sum-=nums[st];
                st++;
            }
            
            
        }
        
        return max;
    }
}