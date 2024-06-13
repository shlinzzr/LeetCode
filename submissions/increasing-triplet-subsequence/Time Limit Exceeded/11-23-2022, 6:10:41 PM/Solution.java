// https://leetcode.com/problems/increasing-triplet-subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len  = nums.length;
        
        
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                                 
                    if(nums[i]<nums[j] && nums[j]<nums[k])
                        return true;
                    
                    
                }
            }
        }
        
        return false;
    }
}