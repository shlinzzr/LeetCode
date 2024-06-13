// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
//         if(nums.length==1)
//             return;
        
//         int zidx=0, curr=0;
        
//         while(curr<nums.length){
//             if(nums[curr]!=0){
//                 int tmp = nums[zidx];
//                 nums[zidx] = nums[curr];
//                 nums[curr]=tmp;
//                 zidx++;
//             }
//             curr++;
                
//         }
        
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[idx++] = nums[i];
            }
        }
        
         for(int i=idx; i<nums.length; i++){
            nums[i]=0;
         }
        
        
        
        
    }
}