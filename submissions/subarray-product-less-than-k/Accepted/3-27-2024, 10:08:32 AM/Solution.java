// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long prod = 1; 
        int st =0;
        int len = nums.length;
        int res = 0;
        for(int ed =0; ed<len; ed++){
            prod*=nums[ed];

            while(st<=ed && prod>=k){
                prod/=nums[st];
                st++;
            }

            res+= ed-st+1;
        }

        return res;
        
    }
}