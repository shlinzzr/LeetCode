// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        HashSet<Integer> set = new HashSet<>();
        int idx = 0;
        
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]))
                continue;
            else 
                nums[idx++] = nums[i];
        }
        
        return idx;
    }
}