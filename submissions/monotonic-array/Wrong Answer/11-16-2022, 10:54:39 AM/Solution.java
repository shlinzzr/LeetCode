// https://leetcode.com/problems/monotonic-array

class Solution {
    public boolean isMonotonic(int[] nums) {
     
        int len = nums.length;
        if(len==1)
            return true;

        if(nums[len-1]-nums[0]==0)
            return false;
        
        boolean isIncreasing = nums[len-1]-nums[0]>0;
        
        for(int i=1; i<len; i++){
            
            if(nums[i]-nums[i-1]==0)
                continue;
            
            if((nums[i]-nums[i-1]>0 !=isIncreasing))
                return false;
            
        }
        
        return true;
        
    }
}