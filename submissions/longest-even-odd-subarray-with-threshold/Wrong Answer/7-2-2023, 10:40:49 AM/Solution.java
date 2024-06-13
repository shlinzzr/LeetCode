// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len = nums.length;
        
        int max =0;
        
        int even =0 ;
        int odd = 0;
        
        
        int st = 0;
        for(int ed = 0; ed<len; ed++){
            
            if(nums[ed]%2==0)
                even++;
            else 
                odd++;
            
            
            if(nums[ed]>threshold){
                odd=0;
                even=0;
                st = ed+1;
            }
            
            if(odd!=even){
                max = Math.max(max, ed-st+1);
            }
                
            
            
            
        }
        return max;
        
        
    }
}