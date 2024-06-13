// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        
        int max = 0;
        
        int st= 0;
        int zero = 0;
        
        boolean ez = false;
        
        
        for(int ed= 0; ed<len;ed++){
            
            if(nums[ed]==0){
                zero++;
                ez=true;
            }
                
            
            while(zero>1){
                
                if(nums[st]==0)
                    zero--;
                st++;
            }
            
            
            if(zero==0){
                max = Math.max(max, ed-st+1);
            }else{
                max = Math.max(max, ed-st);    
            }
            
            
        }
        
        return ez? max : max-1;
    }
}