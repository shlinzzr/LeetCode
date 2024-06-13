// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        int len = nums.length;
        
        int idx = 1;
        
        for(int i=1; i<len; i++){
            
            while(i<len && nums[i]==nums[i-1]){
                i++;
            }
            
            nums[idx] = nums[i];
            
            idx++;
        }
        
        return idx;
        
        
    }
}