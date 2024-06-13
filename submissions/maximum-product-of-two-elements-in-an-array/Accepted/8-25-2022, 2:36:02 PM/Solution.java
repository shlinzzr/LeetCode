// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array

class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        
        
        
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i!=j)
                    max = Math.max(max, (nums[i]-1)*(nums[j]-1));
            }
        }
        return max;
    }
}