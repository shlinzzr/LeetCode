// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        
        for(int n : nums){
            if(res<0){
                res= 0;
            }
            res+=n;
            max = Math.max(max, res);
            
        }
        
        return max;
            
            
    }
}