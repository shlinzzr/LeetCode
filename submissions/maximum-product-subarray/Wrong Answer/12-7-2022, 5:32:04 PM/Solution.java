// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        int res = 0;
        int max = 1;
        int min = 1;

        for(int n : nums){
            if(n<0){
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(n, max * n);
            min = Math.min(n, min * n);
            res = Math.max(max, res);
            
        }

        
        return res;
    

    }

}