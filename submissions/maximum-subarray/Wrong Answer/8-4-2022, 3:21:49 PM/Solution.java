// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int curr =0, max=0;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            
            if(n>0){
                if(curr<0){
                    curr=0;
                }
            }
            
            curr+=n;
      
            
            max = Math.max(max, curr);
        }
        
        return max;
    }
}