// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        int idx = 0;
        boolean oneZero=false;

        int prod=1;
        for(int i=0;i<len; i++){
            int v = nums[i];

            if(v==0){
                if(oneZero==false){
                    oneZero=true;
                    idx = i;
                }
                    
                else return res;
            }else{
                
                prod *= v;
            }

        }


        if(oneZero){
            res[idx] = prod;
            return res;
        } 

        for(int i=0; i<len; i++){
            res[i] = prod/nums[i];
        }

        return res;
        
    }
}