// https://leetcode.com/problems/rotate-array

class Solution {
//     public void rotate(int[] nums, int k) {
//         int[] tmp = new int [k];
        
//         int len = nums.length;
//         for(int i=len-k; i>0; i--){
            
//             if(i<k)
//                  tmp[i]=nums[i];
            
     
//             nums[i] = nums[i+k];
            
//         }
        
//          for(int i=0; i<k; i++){
//             nums[i+len-k]= tmp[i];
//          }
//     }
    
     public void rotate(int[] nums, int k) {
        int[] tmp = new int [nums.length];
        
         
        k = k % nums.length;
         
        for(int i=0; i<nums.length; i++){
            
            tmp[ (i+k)%nums.length] = nums[i];  
            
        }
         
         for(int i=0; i<nums.length; i++){
             
             
             nums[i] = tmp[i];
         }
         
    }
}