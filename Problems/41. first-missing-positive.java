// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int len = nums.length;
        
        int res = len+1;
        
        for(int i=0; i<len; i++){
            
            int val = nums[i]; // val should be at index val-1;
            
            while((nums[i]-1<len && nums[i]-1>=0) && nums[nums[i]-1]!=nums[i]){
                swap(nums, nums[i]-1, i);
            }
        } 
        
        for(int i=0;i<len; i++){
            if(nums[i]!=i+1) return i+1;
        }
        
        return res;
            
        
        
    }
    
    private void swap(int[] nums, int a, int b){
        int t= nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}