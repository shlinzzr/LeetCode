// https://leetcode.com/problems/non-decreasing-array

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean seen = false;
        
        
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]>nums[i]){
                if(seen)
                    return false;
                else {
                    seen=true;
                    i--;
                }
                    
            }
        }
        return true;
    }
}