// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        boolean cz=false, cz2=false;
        int idx = -1;
        long prod=1;
        
        for(int i=0; i<nums.length; i++){
            
            int n = nums[i];
            
            if(n==0){
                
                if(cz==false){
                    cz=true;
                    idx=i;
                }else
                    cz2=true;
            }else{
                prod*=n;
            }
        }
        
        int[] res = new int[nums.length];
        
        if(cz2)
            return res;
        
        if(cz){
            res[idx]=(int)prod;
            return res;
        }
        
        for(int i=0; i<nums.length; i++){
            
            res[i] = (int) prod/nums[i];
        }
        
        return res;
        
        
    
        
    }
}