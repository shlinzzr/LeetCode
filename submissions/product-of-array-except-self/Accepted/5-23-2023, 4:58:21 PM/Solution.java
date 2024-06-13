// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        for(int i=0; i<len; i++){
            
            if(i==0)
                prefix[i]=1;
            else
                prefix[i]=prefix[i-1]*nums[i-1];
            
            int cvt = len-i-1;
            if(cvt==len-1)
                suffix[cvt]=1;
            else{
                suffix[cvt] = suffix[cvt+1]*nums[cvt+1];
            }
            
        }
        
//         for(int i=len-1; i>=0; i--){
            
//             if(i==len-1)
//                 suffix[i]=1;
//             else{
//                 suffix[i] = suffix[i+1]*nums[i+1];
//             }
//         }
        
        int[] res = new int[len];
        
        for(int i=0; i<len; i++){
            
            res[i] = prefix[i]*suffix[i];
        }
        
        return res;
    }
}