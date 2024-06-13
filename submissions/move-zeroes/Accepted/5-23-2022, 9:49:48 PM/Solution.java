// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1)
            return;
        
        int zidx=0, curr=0;
        

        
        while(curr<nums.length){
            if(nums[curr]!=0){
                int tmp = nums[zidx];
                nums[zidx] = nums[curr];
                nums[curr]=tmp;
                zidx++;
            }
            curr++;
                
        }
    }
}