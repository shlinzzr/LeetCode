// https://leetcode.com/problems/continuous-subarrays

class Solution {
    public long continuousSubarrays(int[] nums) {
        int len = nums.length;
        
        long res = 0L;
        
        int st = 0; 
        
        
        
        for(int ed =0; ed<len; ed++){
            
            if(ed-st>0 && Math.abs(nums[ed]-nums[ed-1])>2){
                int width = ed-st;
            
                res = (res + (1+width)*width/2);
            
                st=ed;
            }
            
            
        }
    
        return res;
    }
}