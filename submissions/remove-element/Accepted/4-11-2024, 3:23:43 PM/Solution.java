// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
        
        int idx= 0 ;
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            if(nums[i]!=val){
                nums[idx] = nums[i];
                idx++;
            }
            
            
        }
        
        return idx;
        
    }
}