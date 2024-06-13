// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         for(int i=0;i<nums.length;i++){
            
            
            if(i+k <nums.length){
                
            if(nums[i]==nums[i+k]){
                return true;
            }
            
            
            }
            
        }
        return false;
    }
}