// https://leetcode.com/problems/number-of-unequal-triplets-in-array

class Solution {
    public int unequalTriplets(int[] nums) {
        int len = nums.length;
        
        int res =0;
        
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                
                if(nums[i]==nums[j]) 
                    continue;
                
                for(int k=j+1; k<len; k++){
                   
                    if(nums[j]==nums[k])
                        continue;
                    if(nums[i]==nums[k])
                        continue;
                    
                    res++;
                }
            }
        }
        return res;
    }
}