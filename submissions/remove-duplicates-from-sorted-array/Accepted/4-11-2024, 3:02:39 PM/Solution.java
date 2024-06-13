// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int len = nums.length;
        
        int idx= 1 ;
        
        for(int i=1; i<len ;i ++){
            
            if(nums[i]!=nums[idx-1]){
                nums[idx++] = nums[i];
            }
            
        }
        
        return idx;
        
    }
}