// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        
        int w = 0;
        for(int i=0; i<len ; i++){
            
            if(nums[i]!=0){
                nums[w++] = nums[i];
            }
        }
        
        while(w<len)
            nums[w++]=0;
        
    }
}