// https://leetcode.com/problems/rotate-array

class Solution {
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
        
        
        
        // for(int i=0; i<step; i++)
        //     rotate(nums);
    // }
    
//     private void rotate(int nums[]){
        
//         if(nums.length==1)
//             return;
        
//         int val = nums[nums.length-1];
    
        
//         for(int i=nums.length-1; i>0; i--){
//             nums[i] = nums[i-1];
//         }
        
//             nums[0]=val;
        
//     }
    
}