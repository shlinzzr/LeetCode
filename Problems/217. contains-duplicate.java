// https://leetcode.com/problems/contains-duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        Set<Integer> seen = new HashSet<>();
        for(int i=0; i<len; i++){
            if(seen.add(nums[i])==false)
                return true;
        }
        
        return false;
        
                
    }
}