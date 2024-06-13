// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        
        int zcnt=0;
  
        
        
        for(int i=0; i<nums.length; i++){
            
            if(nums[i]==0)
                zcnt++;
            else{
                
               
                nums[i-zcnt] = nums[i] ;
                 nums[i]=0;
            }
                
            
        
        }
        
    }
    
    
 
}