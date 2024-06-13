// https://leetcode.com/problems/monotonic-array

class Solution {
    public boolean isMonotonic(int[] nums) {
     
        int len = nums.length;
        if(len==1)
            return true;

        int isIncreasing = (nums[len-1]-nums[0]>0) ? 1 : (nums[len-1]-nums[0]==0)? 0 : -1;
        
        for(int i=1; i<len; i++){
            
            if(nums[i]-nums[i-1]==0 && isIncreasing!=0)
                return false;
            
            if((nums[i]-nums[i-1]>0 && isIncreasing!=1))
                return false;
            
            if((nums[i]-nums[i-1]<0 && isIncreasing!=-1))
                return false;
            
        }
        
        return true;
        
    }
}