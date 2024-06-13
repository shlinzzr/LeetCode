// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        
        int max = 0;
        
        int zero=0;
        int cur=0;
        int st=0;
        for(int ed=0; ed<len; ed++){
            if(nums[ed]==1)
                cur++;
            else
                zero++;
            
          
            
            while(zero>1){
                
                if(nums[st]==1)
                    cur--;
                else
                    zero--;
                st++;
            }
            
            max = Math.max(max, zero==1?ed-st+1-zero : ed-st);
            
        }
        
        return max;
        
        
        
    }
}