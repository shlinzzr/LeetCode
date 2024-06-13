// https://leetcode.com/problems/non-decreasing-array

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean seen = false;
        
       
        for(int i=0; i<nums.length-1; i++){
            
            if(nums[i]<=nums[i+1])
                continue;
            
            if(seen)
                 return false;
            
            
            // chg front //  1   4   2
                         // i-1  i  i+1
                          
            if(i==0 || nums[i-1]<=nums[i+1]) // i=0 is because there is no n-1 element to check
                nums[i]= nums[i+1]; // shrink left
            else
                nums[i+1] = nums[i]; // or impove right
            seen=true;
        }
        return true;
    }
}