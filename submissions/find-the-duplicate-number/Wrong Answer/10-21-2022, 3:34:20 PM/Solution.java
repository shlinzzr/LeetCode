// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            
            if(i+1!=nums[i] && nums[i]!=nums[nums[i]-1]){
                swap(nums, i , nums[i]-1);
            }
        }
        
        return nums[nums.length-1];
    }
    
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}