// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1)
            return nums[0];
        
        int odd=nums[0], even=nums[1];
        
   
        
        for(int i=2; i<nums.length; i++){
            
            if(i+1==nums.length){
                odd += nums[i];
                even+=nums[i];
                
            }else  if(odd+nums[i+1] > odd+nums[i] &&  odd+nums[i+1] > even +nums[i+1] ){
               odd += nums[i+1];
               even+=nums[i];
                i+=2;
                
            }else{
                odd+=nums[i];
                even+=nums[i+1];
                i++;
            }
            
          
        }
        
        return even>odd? even : odd;
    }
}