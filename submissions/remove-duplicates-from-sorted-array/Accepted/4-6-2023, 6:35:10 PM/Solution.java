// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {

        int idx = 1;
        
        
        for(int i=1; i<nums.length; i++){
            
            if(nums[i] == nums[i-1]){
                //do nothing
            }
                
            else{
                nums[idx] = nums[i];
                idx++;
            }
        }
        
        return idx;
            
            
        
    }
}