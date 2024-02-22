// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        
        int xor = 0;
        for(int n : nums){
            xor^=n;
        }
        
        return xor;
//         int len = nums.length;
        
        
//         // [2,2,1]  // val should be on the pos val-1 => pos i should be val i+1
        
//         for(int i=0; i<len; i++){
            
//             if(nums[nums[i]-1]==nums[i]) return nums[i];
//             while(nums[nums[i]-1]!=nums[i]){
//                 swap(nums, i, nums[i]-1);
                
//             }
//         }
//         return -1;
        
//     }
    
//     private void swap(int[] nums, int a, int b){
//         int t = nums[a];
//         nums[a] = nums[b];
//         nums[b] = t;
    }
}