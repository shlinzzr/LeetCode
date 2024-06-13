// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;

        int res = Integer.MIN_VALUE;
        int max = 1; 
        int min = 1;
        
        for(int i=0; i<len; i++){
            
            if(nums[i]<0){
                int t = max;
                max = min;
                min = t;
            }
            
            max = Math.max(max* nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);
            res = Math.max(max, res);
            
        }
        
        return res;
        
    }
}