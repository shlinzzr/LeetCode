// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        
        if(k==0)
            return 0;
        
        int cnt=0;
        int prod=1;
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            prod*=nums[ed];
            
            while(prod>=k && st<=ed){
                prod/=nums[st++];
            }
            cnt+= ed-st+1;
           
        }
        
        return cnt;
    }
}
