// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1)
            return;
        
        int zidx=0, curr=0;
        

        
        while(curr<nums.length){
            if(nums[curr]!=0){
                nums[zidx] = nums[curr];
                nums[curr]=0;
                zidx++;
            }
            curr++;
                
        }
    }
}