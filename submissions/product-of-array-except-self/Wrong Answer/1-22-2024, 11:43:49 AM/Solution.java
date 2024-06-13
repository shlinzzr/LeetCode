// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        
        int[] res = new int[len];
        
        int prod = 1;
        boolean containZero = false;
        boolean containTwoZero = false;
        for(int n: nums){
            
            
            if(n==0 && containZero==false){
                containZero = true;
                
            }else if(containZero==true){
                return res;
            }
            prod*=n;
            
        }
        
        
        
        
        
        
        for(int i=0; i<len; i++){
            
            if(containZero){
                
                if(nums[i]!=0)
                    res[i]=0;
                else 
                    res[i] = prod;
            }else
                res[i] = prod/nums[i];
        }
        
        return res;
    }
}