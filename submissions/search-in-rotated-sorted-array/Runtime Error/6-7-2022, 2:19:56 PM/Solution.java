// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        
        for(int i : nums){
            if(target==nums[i])
                return i;
        }
        
        return -1;
    }
}