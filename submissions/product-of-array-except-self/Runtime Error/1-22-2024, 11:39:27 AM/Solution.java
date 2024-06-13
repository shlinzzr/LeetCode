// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        
        int prod = 1;
        for(int n: nums){
            prod*=n;
        }
        
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            res[i] = prod/nums[i];
        }
        
        return res;
    }
}