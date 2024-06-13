// https://leetcode.com/problems/maximum-score-of-a-good-subarray

class Solution {
    public int maximumScore(int[] nums, int k) {
       
        int max = nums[k];
        
        int min = nums[k];
        
        int len = nums.length;
        
        int st=k, ed=k;
        
        while(st>0 || ed<len-1){
            
            
            if(st>0 && nums[st]>=nums[ed] || ed==len-1){
                st--;
                min = Math.min(min, nums[st]);
                
            }else{
                ed++;
                min = Math.min(min, nums[ed]);
            }
            
            max = Math.max(max, min*(ed-st+1));
            
        }
                           
                           return max;
        
        
    }
}