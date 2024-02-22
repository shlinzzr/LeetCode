// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        
        long prod = 1;
        
        int st=0;
        int res =0 ;
        int cnt = 0;
        for(int ed=0; ed<len; ed++){
            
            prod *= nums[ed];
            
            while(st<=ed && prod>=k){
                prod/=nums[st++];
            }
            
            cnt+=ed-st+1;
        }
        
        return cnt;
    }
}