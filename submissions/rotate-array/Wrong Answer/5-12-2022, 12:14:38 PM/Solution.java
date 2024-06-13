// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        
        
        int len = nums.length;
         k = k % nums.length;
        
        
        int arr[] = new int[k];
        
        for(int i= len-k; i<len; i++)
            arr[i-(len-k)]=nums[i];
        
        for(int i=len-1; i>=len-1-k; i--){
            nums[i] = nums[i-len+k+1];
        }
            
        
        for(int i= 0; i<k; i++)
            nums[i]=arr[i];
        
        
        
        
        // for(int i=0; i<step; i++)
        //     rotate(nums);
    }
    
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