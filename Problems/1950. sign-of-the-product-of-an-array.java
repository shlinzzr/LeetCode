// https://leetcode.com/problems/sign-of-the-product-of-an-array

class Solution {
    public int arraySign(int[] nums) {
        
        int prod=1;
        
        for(int n : nums){
            
            if(n==0)
                return 0;
            
            if(n<0){
                prod*=-1;
            }
            
        }
        
        return prod;
    }
}