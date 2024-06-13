// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        int len = nums.length;
        
        
        int right = 2;
        int left = 1;
        
        while(right<len){
            
            if (nums[right]==nums[left] && nums[right]==nums[left-1])
                right++;
            else
            {
                left++;
                nums[left]=nums[right];
                right++;
            }
        }
        
        return left+1;
        
    }
}