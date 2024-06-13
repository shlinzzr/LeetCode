// https://leetcode.com/problems/increasing-triplet-subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        boolean res = false;
        
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                
                if(nums[i]>=nums[j])
                    continue;
                
                for(int k=j+1; k<nums.length; k++){
                                    
                    if(nums[j]>=nums[k])
                        continue;

                    return true;
                    
                }
            }
            
            
        }
        
        return res;
    
    }
}