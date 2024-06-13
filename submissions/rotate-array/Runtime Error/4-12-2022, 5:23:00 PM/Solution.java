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
    
//      public void rotate(int[] nums, int k) {
//         int[] tmp = new int [nums.length];
        
         
//         k = k % nums.length;
         
//         for(int i=0; i<nums.length; i++){
            
//             tmp[ (i+k)%nums.length] = nums[i];  
            
//         }
         
//          for(int i=0; i<nums.length; i++){
//              nums[i] = tmp[i];
//          }
         
//     }
    
    
      public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
           reverse(nums, 0, k-1);
           reverse(nums, k, nums.length-1);
        
         
    }
    
    private void reverse(int nums[], int st, int ed){
        
        while(st<ed){
            int tmp = nums[st];
            nums[st]= nums[ed];
            nums[ed]= tmp;
            st++;
            ed--;
        }
            
    }
}