// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        

        for(int n : nums){
            if(n<0){
                int t = max;
                max = min;
                min = t;
            }

            max = Math.max(n, max*n);
            min = Math.min(n, min*n);
            
            
            res = Math.max(max, res);
        }


        return res;
        
    }
}