// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    
    int res;
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        res =0;
        
        
        for(int i=0; i<nums.length; i++){
            
            int curr=1;
            
            for(int j=0; j<nums.length; j++){
                
                curr*=nums[j];
                if(curr<k)
                    res++;
                else
                    break;
                
            }
        }
        
        
//         int st=0, curr=1;
//         for(int ed=0; ed<nums.length; ed++){
            
//             if(nums[ed]<k)
//                 res++;
            
//             curr *= nums[ed];
            
//             if(curr<k){
//                 res++;
//             }
            
//             while(curr>k){
                
//                 if(nums[st]==0){
//                     curr=1;
//                 }else{
//                     curr=curr/nums[st];
//                 }
//                 st++;
//             }
            
//             if(curr<k)
//                 res++;
            
//         }
        
        return res;
        
        
    }
    
    private void helper(){
        
    }
}