// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = -10000;
        int curr = 0;
        
        for(int i=0; i<nums.length; i++){
            int n= nums[i];
            
            if(i==0){
                curr = nums[0];
                max = Math.max(curr, max);
                continue;
            }
            
            if(curr<0)
                curr = n;
            else 
                curr +=n;
            
            max = Math.max(curr, max);
            
            
        }
        
        return max;
        
        
    }
}