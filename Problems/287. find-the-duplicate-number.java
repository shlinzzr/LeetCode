// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            int val = nums[i];
            
            while((nums[i]-1>=0 && nums[i]-1<len) && nums[nums[i]-1]!=nums[i]){
                swap(nums, nums[i]-1, i);
            }
            
        }
        
        for(int i=0; i<len; i++){
            if(nums[i]!=i+1) return nums[i];
        }
        
        return -1;
        
    }
    
    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}