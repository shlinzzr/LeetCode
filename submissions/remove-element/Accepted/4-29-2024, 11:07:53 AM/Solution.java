// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
        
        
        int idx= 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[idx++] = nums[i];
            }
        }
        
        int cnt = idx;
        while(idx<nums.length){
            nums[idx++] = val;
        }
        
        return cnt;
        
    }
}