// https://leetcode.com/problems/ways-to-split-array-into-good-subarrays

class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int M = (int)1e9+7;
        
        int len = nums.length;
        
        boolean firstOne = false;
        
        
        int z=1;
        int res =1;
        for(int i=0; i<len ; i++){

            if(nums[i]==1){
                firstOne=true;
                
                res = (res*z)%M;
                z=1;
            }else{
                  if(firstOne)
                      z++;
                
            }
               
            // System.out.println(i + " r=" + res + " z=" + z + " fo="+firstOne);
          
            
            
        
        } 
        
        
        return firstOne ? res : 0;
        
    }
}