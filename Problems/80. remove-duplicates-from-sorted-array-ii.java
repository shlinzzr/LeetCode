// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        
        int left =1, right=2;
        
        while(right<len){
            
            if(nums[right]==nums[left] && nums[right]==nums[left-1]){
                
                right++;
            }else{
                
                nums[left+1] = nums[right];
                left++;
                right++;
                
            }
        }
        
        return left+1;
        
        
        
    }
        
}