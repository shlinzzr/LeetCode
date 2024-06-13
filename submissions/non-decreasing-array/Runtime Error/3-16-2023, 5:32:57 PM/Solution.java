// https://leetcode.com/problems/non-decreasing-array

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean seen = false;
        
        int i=0, j=1;
        for(; i<nums.length; ){
            if(nums[i]>nums[j]){
                if(seen)
                    return false;
                else {
                    seen=true;
                    i--;
                    continue;
                }
                
            }
            
            i++;
            j++;
        }
        return true;
    }
}