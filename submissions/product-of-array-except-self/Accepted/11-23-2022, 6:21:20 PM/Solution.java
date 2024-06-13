// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        long p = 1;
        
        boolean containZero=false;
        boolean cTwoZero=false;
        for(int n: nums){
            if(n==0){
                if(containZero==true)
                    cTwoZero=true;
                else
                    containZero=true;
                
            }else
                p*=n;
            
        }
            
        
        
        
        int[] res = new int[nums.length];
        
        if(cTwoZero)
            return res;
        
        for(int i=0; i<nums.length; i++){
        
            if(containZero){
                if(nums[i]==0){
                    res[i] = (int)p;
                    return res;
                }
                
            }else
                res[i] = (int)p/nums[i];
        }
        
        return res;
    }
}