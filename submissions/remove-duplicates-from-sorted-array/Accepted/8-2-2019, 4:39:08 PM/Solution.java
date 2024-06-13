// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int s = 0;
        
        for(int i=1; i<nums.length;i++){
            
            if(nums[s]!=nums[i]){
                s++;
                nums[s]=nums[i];
            }
            
        }
        return s+1;
    }
    
}
