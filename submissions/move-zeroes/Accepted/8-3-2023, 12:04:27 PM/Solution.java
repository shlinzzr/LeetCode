// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        
        int idx=0;
        
        for(int i=0; i<len; i++){
            
            if(nums[i]!=0){
                nums[idx++]=nums[i];
            }
            
            
        }
        while(idx<len){
            nums[idx++]=0;
        }
    }
}