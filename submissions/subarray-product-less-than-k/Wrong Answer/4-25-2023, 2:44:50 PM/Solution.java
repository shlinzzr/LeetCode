// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        
        long prod = 1;
        int cnt=0;
        
        
        for(int st =0; st<len-1; st++){
            prod=1;
            for(int ed=st; ed<len; ed++){
                prod*=nums[ed];
                if(prod>k)
                    break;
                cnt++;
            }
        }
        
        
//         for(int n : nums){
            
//             prod*=k;
            
//             while(st<len && prod>k){
//                 prod/=nums[st++];
//             }
//             cnt++;
//         }
        
        return cnt;
        
        
    }
}