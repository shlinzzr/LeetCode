// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        int max=1, min=1, res=Integer.MIN_VALUE;
        
        for(int n: nums){
            
            if(n<0){
                int tmp = min;
                min = max;
                max = min;
            }
            
            max = Math.max(n, max*n);
            min = Math.min(n, min*n);
            res = Math.max(res, max);
            
        }
        
        return res;
    }
}