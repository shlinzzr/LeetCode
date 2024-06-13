// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int len = nums.length;

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