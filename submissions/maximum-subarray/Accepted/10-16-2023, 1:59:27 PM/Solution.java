// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int cur = 0;
        for(int n : nums){

            if(cur<0)
                cur=0;
            cur+= n;
            res = Math.max(res, cur);
        }

        return res;
        
    }
}