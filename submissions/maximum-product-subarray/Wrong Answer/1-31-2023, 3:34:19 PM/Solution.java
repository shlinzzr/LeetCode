// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max =1;
        int min=1;
        
        for(int n : nums){
            if(n<0){
                int tmp = max;
                max=min;
                min=tmp;
            }
            
            max = Math.max(max, max*n);
            min = Math.min(min, min*n);
            res = Math.max(res, max);
        }
        
        
        return res;
    }
    
    
}