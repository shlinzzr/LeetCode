// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int n: nums){
            
            
            
            if(sum<0)
                sum=0;
            sum+=n;
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
}