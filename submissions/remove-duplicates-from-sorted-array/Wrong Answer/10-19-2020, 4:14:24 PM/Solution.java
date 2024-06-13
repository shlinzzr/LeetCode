// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] != nums[i] ){
                count++;
            }
        }
        
        return count;
        
    }
}