// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        long p=1;
        boolean cz=false;
        boolean c2z=false;
        
        for(int n : nums){
            
            if(n==0){
                if(cz==false)
                    cz=true;
                else 
                    c2z=true;
            }else{
                p*=n;
            }
            
        }
        
        int len = nums.length;
        int[] res = new int[len];
        
        if(c2z==true)
            return res;
            
        
        for(int i=0; i<len; i++){
            
            if(cz){
                if(nums[i]==0){
                    res[i]=(int)p;
                    return res;
                }
            }else{
                res[i] = (int)p/nums[i];
            }
        }
        return res;

    }
}