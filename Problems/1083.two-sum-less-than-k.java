// https://leetcode.com/problems/two-sum-less-than-k

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int len = nums.length;
        int max=0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(nums[i]+nums[j]<k){
                    max = Math.max(max, nums[i]+nums[j]);
                }
            }
        }

        return max==0 ? -1 : max;
    }
}